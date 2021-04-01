package featuresameple.functionalinterfaces;
 
@FunctionalInterface
public interface TestFunctinal2 {
	
	public Integer methodAbstractPow2(Integer a);
	
	//public void methodAbstract2(); // error
	
	default void methodDefault1(){
		System.out.println("TestFunctinal2 Interface 1");
	}
	default void methodDefault2(){
		System.out.println("TestFunctinal2 Interface 2");
	}
	default void methodDefault3(){
		System.out.println("TestFunctinal2 Interface 3");
	}
	
}
