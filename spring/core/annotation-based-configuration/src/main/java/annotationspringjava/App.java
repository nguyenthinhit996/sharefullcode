package annotationspringjava;

import annotationspringjava.beancreate.AutowiredContructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import annotationspringjava.controller.AppController;


@Configuration
@ComponentScan
public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appcontext = new AnnotationConfigApplicationContext(App.class);	
//		AppController appController = appcontext.getBean(AppController.class);
//		appController.getAvagraveOfStudent();
//		AutowiredContructor appController = appcontext.getBean(AutowiredContructor.class);
//		appController.getAvagraveOfStudent();


//		AutowiredContructor appController = appcontext.getBean(AutowiredContructor.class);
		appcontext.close();
	}
	
}
