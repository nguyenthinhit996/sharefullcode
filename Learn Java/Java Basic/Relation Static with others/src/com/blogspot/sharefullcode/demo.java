package com.blogspot.sharefullcode;

public class demo {

	static int staticVariable =100;
	int nonStaticVariable=100;
	
	static void staticFunctional() {
		System.out.println("Static functional");
		System.out.println("Use Static Variable " + staticVariable);
		System.out.println("Not Use Non Variable in Static Functional " + nonStaticVariable); // error Cannot make a static reference to the non-static
		//use function
		staticFunctional2(); 
		nonStaticFunctional2(); // error when static Functional use functional normal.
	}
	
	void nonStaticFunctional() {
		System.out.println("non static functional");
		System.out.println("Use Static Variable " + staticVariable);
		System.out.println("Use Non Variable in normal Functional " + nonStaticVariable); // ok
		//use function
		staticFunctional2(); 
		nonStaticFunctional2();
	}
	
	
	static void staticFunctional2() {
		System.out.println("Static functional");
	}
	
	void nonStaticFunctional2() {
		System.out.println("non static functional");
	}
}
