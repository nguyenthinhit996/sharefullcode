//package com.blogspot.sharefullcode.nullcheck;
//
//import org.checkerframework.checker.nullness.qual.NonNull;
//
//public class A {
//	@NonNull
//	String a;
//
//	public A() {
//	 
//		
//		doSomethingA();
//		a = "";
//		// Now, all fields of A are initialized.
//		// However, if this constructor is invoked as part of 'new B()', then
//		// the fields of B are not yet initialized.
//		// If we would type 'this' as @Initialized, then the following call is valid:
//		System.out.println("Contruct A");
//		doSomethingC();
//		 
//		doSomethingD();
//	}
//
//	void doSomething() {	
//		System.out.println("A");
//	}
//	void doSomethingC() {	
//		System.out.println("C");
//	}
//	void doSomethingD() {	
//		System.out.println("D");
//	}
//	
//	void doSomethingA() {
//			
//			System.out.println("A");
//		}
//	
//	public static void main(String[] args) {
//		B d= new B();
//		//d.doSomething();
//	}
//	
//}
//
//class B extends A {
//	@NonNull
//	String b;
//
//	@Override
//	void doSomething() {
//		System.out.println(" doSomething B");
//		// Dereferencing 'b' is ok, because 'this' is @Initialized and 'b' @NonNull.
//		// However, when executing 'new B()', this line throws a null-pointer exception.
//			b.toString();
//	}
//	
//	
//}