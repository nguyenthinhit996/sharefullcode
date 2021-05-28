package relativeentity.onetoone;

import java.util.List;

import org.hibernate.SessionFactory;

import relativeentity.entitys.C3Address3;
import relativeentity.entitys.C3User3;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class C3UsingaSharedPrimaryKey {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		sessionFactory.openSession();
		
		//TypedQuery of JPA use Table entity
		String sqlTypeQuery = "Select u from C3User3 u ";
		List<C3User3> ds = sessionFactory.createEntityManager().createQuery(sqlTypeQuery,C3User3.class).getResultList();	
		ds.stream().forEach(System.out::println);
		
		
		System.out.println("---------------------------------NativeQuery of JPA------------------------------");
		//NativeQuery of JPA
		// use table in DB
		String nativeQuery = "Select * from address3";
		List<?> ds1 = sessionFactory.createEntityManager().createNativeQuery(nativeQuery,C3Address3.class).getResultList();
		List<C3Address3> dsAddress = (List<C3Address3>) ds1;
		dsAddress.stream().forEach(System.out::println);
		
		sessionFactory.close();
		
	}
	
}
