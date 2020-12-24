package featuresameple.annotations.newfeed;

import java.util.ArrayList;
import java.util.List;


public class AnnotationDemo implements ParentClassExample {
	
	 @Override
	 public void methodA() {
		 System.out.println("children appearance");
	}
	
	/*
	 * @Override public void methodA(int x) {
	 * System.out.println("children appearance"); }
	 */
	 

	@SuppressWarnings({ "unchecked", "rawtypes"})
	void suppressWarnigsDemo() {
		 List list= new ArrayList();
		 list.add("a1");
		 list.add("a2");
		 list.add("a3");
		 list.add("a4");
		 list.forEach(System.out::println);
	 }
	
	@SuppressWarnings({"unchecked","deprecation"})
	public static void main(String[] args) {
		DeprecatedClass newObject = new DeprecatedClass();
		newObject.deprecatedFunction();
		newObject.aDeprecated=222;
	}
}

interface ParentClassExample {
	void methodA();
}

class DeprecatedClass{
	@Deprecated
	void deprecatedFunction(){
		System.out.println("Function @Deprecated");
	}
	@Deprecated
	public int aDeprecated = 100;
}