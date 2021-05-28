package relativeentity.onetoone;

import java.util.List;

import org.hibernate.SessionFactory;

import relativeentity.entitys.C2Address2;
import relativeentity.entitys.C2User2;
import relativeentity.hibernateconfiguration.HibernateUtilNormal;

public class C2UsingJoinTableWithTableMiddle2 {
	
	public static void main(String[] args) {
		
		 
		SessionFactory sessionFactory = HibernateUtilNormal.getSessionFactory();
		sessionFactory.openSession();
		
		//TypedQuery of JPA use Table entity
		String sqlTypeQuery = "Select u from C2User2 u ";
		List<C2User2> ds = sessionFactory.createEntityManager().createQuery(sqlTypeQuery,C2User2.class).getResultList();	
		ds.stream().forEach(System.out::println);
		
		
		System.out.println("---------------------------------NativeQuery of JPA------------------------------");
		//NativeQuery of JPA
		// use table in DB
		String nativeQuery = "Select * from address2";
		List<?> ds1 = sessionFactory.createEntityManager().createNativeQuery(nativeQuery,C2Address2.class).getResultList();
		List<C2Address2> dsAddress = (List<C2Address2>) ds1;
		dsAddress.stream().forEach(System.out::println);
		
		sessionFactory.close();
	}
	
}
