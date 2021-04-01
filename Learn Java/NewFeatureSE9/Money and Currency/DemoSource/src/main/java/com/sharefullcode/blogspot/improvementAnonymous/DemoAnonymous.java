package com.sharefullcode.blogspot.improvementAnonymous;

public class DemoAnonymous {

	public static void main(String[] args) {
		// not transport generic parameter
		A<String> instance = new A<>() {

			@Override
			public void abc() {
				System.out.println("System out");
			}
		};
		instance.abc();
		// transport generic parameter
		A<String> instance2 = new A<String>() {

			@Override
			public void abc() {
				System.out.println("System out 2");
			}
		};
		instance2.abc();
	}
}

// abstract class with generic class parameter type R
abstract class A<R> {
	public abstract void abc();
}