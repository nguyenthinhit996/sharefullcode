package com.sharefullcode.blogspot;

import java.util.ArrayList;
import java.util.List;

public class DemoAnnotationSafeVarargs {
	// Annotation SafeVarargs
	// java 9 applies for method and contructor
	// Final method, static method, Constructor, pravite method instance

	@SafeVarargs
	final void finalFunction(List<String>... products) {
		for (List<String> list : products) {
			System.out.println(list);
		}
	}
	
	@SafeVarargs
	final void installFunction(List<String>... products) {
		for (List<String> list : products) {
			System.out.println(list);
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Laptop");
		list.add("Tablet");

		DemoAnnotationSafeVarargs demo = new DemoAnnotationSafeVarargs();
		demo.finalFunction(list);
		demo.installFunction(list);
	}
}
