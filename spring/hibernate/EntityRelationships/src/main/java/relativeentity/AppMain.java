package relativeentity;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext("relativeentity.*");
 
		SessionFactory sessionFactory = con.getBean(SessionFactory.class);
		sessionFactory.openSession();
		System.out.println("fasdfadsf");
	}
	
}
