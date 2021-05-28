package relativeentity.onetoone;

import java.util.List;

import org.hibernate.SessionFactory;

import relativeentity.entitys.C1Address;
import relativeentity.entitys.C1User;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class C1UsingaForeignKey {
	
	public static void main(String[] args) {
		
		 
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		sessionFactory.openSession();
		
		//TypedQuery of JPA use Table entity
		String sqlTypeQuery = "Select u from C1User u ";
		List<C1User> ds = sessionFactory.createEntityManager().createQuery(sqlTypeQuery,C1User.class).getResultList();	
		ds.stream().forEach(System.out::println);
		
		
		System.out.println("---------------------------------NativeQuery of JPA------------------------------");
		//NativeQuery of JPA
		// use table in DB
		String nativeQuery = "Select * from address1";
		List<?> ds1 = sessionFactory.createEntityManager().createNativeQuery(nativeQuery,C1Address.class).getResultList();
		List<C1Address> dsAddress = (List<C1Address>) ds1;
		dsAddress.stream().forEach(System.out::println);
		
		sessionFactory.close();
	}
	
}
