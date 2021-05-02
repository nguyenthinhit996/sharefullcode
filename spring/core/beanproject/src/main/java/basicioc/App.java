package basicioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basicioc.beanannotations.Pojobeanannotation;


public class App {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		System.out.println("---------------------Function Run-----------------------------");
//		// Sử dụng constructor
//		StudentPOJO exampleBean = appContext.getBean("exampleBean", StudentPOJO.class);
//		System.out.println(" constructor default: " + exampleBean.getName());
//		System.out.println(" isSingleton exampleBean: " + appContext.isSingleton("exampleBean"));
//
//		// Sử dụng static factory method
//		StudentPOJO2 exampleBean2 = appContext.getBean("exampleBean2", StudentPOJO2.class);
//		System.out.println("static factory method: " + exampleBean2.getName());
//
//		// Sử dụng instance factory method type 2 static factory-method
//		Printable type2 = appContext.getBean("type2", Printable.class);
//		System.out.println("type2 ");
//		type2.prints();
//
//		// Sử dụng instance factory method type 3 non-static factory-method
//		Printable type3 = appContext.getBean("type3", Printable.class);
//		System.out.println("type3");
//		type3.prints();
//		
//		System.out.println("---------------------Dependency test-----------------------------");
//		
//		ContructPOJODependency constructorarg = appContext.getBean("constructorarg", ContructPOJODependency.class);
//		System.out.println("Dependency test-");
//		System.out.println(constructorarg.toString());
//		
//		
//		ContructPOJODependency setterarg = appContext.getBean("setterarg", ContructPOJODependency.class);
//		System.out.println("Dependency test setterarg-");
//		System.out.println(setterarg.toString());

//		System.out.println("---------------------life cycle -----------------------------");
//		
//		ContructPOJODependencyLifeCycle lifecycle = appContext.getBean("lifecycle", ContructPOJODependencyLifeCycle.class);
//		System.out.println("life cycle callback method");
//		System.out.println(lifecycle.toString());
//		
//		ContructPOJODependencyLifeCycleAnnotation lifecycleanotation = appContext.getBean("lifecycleanotation", ContructPOJODependencyLifeCycleAnnotation.class);
//		System.out.println("life cycle annotation");
//		System.out.println(lifecycleanotation.toString());

		System.out.println("---------------------Use @Bean Annotaion -----------------------------");
		
		// use @bean in class @Configuration 
		System.out.println("--------------------- use @bean in class @Configuration  -----------------------------");
		ApplicationContext ssss = new AnnotationConfigApplicationContext("basicioc.*");
		Pojobeanannotation object = ssss.getBean("getInterBeanReferences", Pojobeanannotation.class);
		System.out.println(object.toString());
		
		
		// use @Bean in class normal lite mode bean 
		System.out.println("--------------------- use @bean in class non @Configuration  -----------------------------");
		// use it in java configurarion error
		//Pojobeanannotation objects = ssss.getBean("getBeanInNormalClassOrNotConfigAnnoClass", Pojobeanannotation.class); //error NoSuchBeanDefinitionException: No bean named
		// use bean lite it in file xml 
		Pojobeanannotation pojobeanannotation = appContext.getBean("useBeanInClassNormal", Pojobeanannotation.class);
		System.out.println(pojobeanannotation.toString());
		
		
		((ClassPathXmlApplicationContext) appContext).close();
		((AnnotationConfigApplicationContext) ssss).close();
		System.out.println("---------------------Function Run-----------------------------");
	}

}
