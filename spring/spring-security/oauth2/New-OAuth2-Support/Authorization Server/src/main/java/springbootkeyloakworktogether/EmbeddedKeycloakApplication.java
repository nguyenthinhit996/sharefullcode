package springbootkeyloakworktogether;

import java.util.NoSuchElementException;

import org.keycloak.Config;
import org.keycloak.models.AccountRoles;
import org.keycloak.models.AdminRoles;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.cache.infinispan.UserCacheSession;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.services.managers.ApplianceBootstrap;
import org.keycloak.services.managers.RealmManager;
import org.keycloak.services.resources.KeycloakApplication;
import org.keycloak.services.util.JsonConfigProviderFactory;
import org.keycloak.util.JsonSerialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import springbootkeyloakworktogether.KeycloakServerProperties.AdminUser;

public class EmbeddedKeycloakApplication extends KeycloakApplication {

	Logger log = LoggerFactory.getLogger(this.getClass());
	static KeycloakServerProperties keycloakServerProperties;

	public EmbeddedKeycloakApplication() {
		createMasterRealmAdminUser();
		createBaeldungRealm();
	}

	protected void loadConfig() {
		JsonConfigProviderFactory factory = new RegularJsonConfigProviderFactory();
		Config.init(factory.create().orElseThrow(() -> new NoSuchElementException("No value")));
	}

	private void createMasterRealmAdminUser() {
		KeycloakSession session1 = getSessionFactory().create();
		KeycloakSession session2 = getSessionFactory().create();
		AdminUser admin = keycloakServerProperties.getAdminUser();
		try {
			session1.getTransactionManager().begin();
			UserCacheSession cacheds = (UserCacheSession) session1.users();
			cacheds.clear();
			session1.getTransactionManager().commit();

//			ApplianceBootstrap applianceBootrap = new ApplianceBootstrap(session2);
			
			session2.getTransactionManager().begin();

//			---
			RealmModel realm = session2.realms().getRealm(Config.getAdminRealm());
			session2.getContext().setRealm(realm);

			if (session2.users().getUsersCount(realm) > 0) {
				UserModel userModel = session2.userCache().getUsers(realm).get(0);
				session2.users().preRemove(realm);
				session2.userStorageManager().removeUser(realm,userModel);
			}

			UserModel adminUser = session2.users().addUser(realm, admin.getUsername());
			adminUser.setEnabled(true);

			UserCredentialModel usrCredModel = UserCredentialModel.password(admin.getPassword());
			session2.userCredentialManager().updateCredential(realm, adminUser, usrCredModel);

			RoleModel adminRole = realm.getRole(AdminRoles.ADMIN);
			adminUser.grantRole(adminRole);
			
			// test add new user normal for realm admin
			UserModel normalUser = session2.users().addUser(realm, "thinh");
			adminUser.setEnabled(true);

			UserCredentialModel usrNormalCredModel = UserCredentialModel.password("123");
			session2.userCredentialManager().updateCredential(realm, normalUser, usrNormalCredModel);

			normalUser.setFirstName("nguyen");
			normalUser.setLastName("thinh");
			normalUser.setEnabled(true);
			
			RoleModel adminRole1 = realm.getRole(AdminRoles.MANAGE_CLIENTS);
			normalUser.grantRole(adminRole1);
			RoleModel adminRole2 = realm.getRole(AdminRoles.MANAGE_USERS);
			normalUser.grantRole(adminRole2);
			RoleModel adminRole3 = realm.getRole(AdminRoles.MANAGE_AUTHORIZATION);
			normalUser.grantRole(adminRole3);
		

//		        --

//			applianceBootrap.createMasterRealmUser(admin.getUsername(), admin.getPassword());
			session2.getTransactionManager().commit();

		} catch (Exception e) {
			log.error("Not create use admin");
			session1.getTransactionManager().rollback();
			session2.getTransactionManager().rollback();
		}
		session1.close();
		session2.close();
	}

	private void createBaeldungRealm() {
		KeycloakSession session = getSessionFactory().create();
		KeycloakSession session2 = getSessionFactory().create();


		try {
			org.springframework.core.io.Resource lessonRealmImport = new ClassPathResource(
					keycloakServerProperties.getRealmImportFile());
			RealmRepresentation objecrRealm = JsonSerialization.readValue(lessonRealmImport.getInputStream(), RealmRepresentation.class);
			
			session.getTransactionManager().begin();
			RealmManager manager = new RealmManager(session);
			RealmModel object = manager.getRealm(objecrRealm.getRealm());		
			if(null!=object) {
				manager.removeRealm(object);
			}
			session.getTransactionManager().commit();
			
			session2.getTransactionManager().begin();
			RealmManager manager2 = new RealmManager(session2);
			manager2.importRealm(objecrRealm);
			session2.getTransactionManager().commit();
			
		} catch (Exception e) {
			log.error(" not create application cloak ");
			session.getTransactionManager().rollback();
			session2.getTransactionManager().rollback();
		}
		session.close();
		session2.close();
	}

}
