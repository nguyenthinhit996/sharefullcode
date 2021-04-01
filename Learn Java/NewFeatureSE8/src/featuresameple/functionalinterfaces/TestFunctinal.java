package featuresameple.functionalinterfaces;
 
@FunctionalInterface
public interface TestFunctinal {
	
	public Integer methodAbstractPow(Integer a);
	
	//public void methodAbstract2(); // error
	
	default void methodDefault1(){
		System.out.println("Functional Interface 1");
	}
	default void methodDefault2(){
		System.out.println("Functional Interface 2");
	}
	default void methodDefault3(){
		System.out.println("Functional Interface 3");
	}
	
}
