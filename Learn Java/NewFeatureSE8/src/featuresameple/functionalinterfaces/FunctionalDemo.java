package featuresameple.functionalinterfaces;

import java.util.function.Consumer;

public class FunctionalDemo{
 
	static TestFunctinal s = (Integer x)->{
		return x*x;
	};
	
	
	public static void main(String[] args) {
		Integer pow2 = s.methodAbstractPow(20);
		System.out.println(pow2);
		
		Consumer<Integer> consumer = (value) -> System.out.println(value);
	}
	
}
