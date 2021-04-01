package com.sharefullcode.blogspot;

public class DemoVarargsParameter {

	// Accept zero or multiple arguments. before we used overload that use it
	// Systax
	// return_type method_name (data_type ... Variable)

	void rule1(Integer... integers) {
		for (Integer integer : integers) {
			System.out.print(integer+" ");
		}
		System.out.println();
	}

	void rule1(String name, Integer... integers) {
		System.out.println(name);
		for (Integer integer : integers) {
			System.out.print(integer+" ");
		}
	}
	
	public static void main(String[] args) {
		DemoVarargsParameter demoVarargsParameter = new DemoVarargsParameter();
		demoVarargsParameter.rule1(1,2,3,4,5,56,7);
		System.out.println("----------------------------------");
		demoVarargsParameter.rule1("Functional Overload multi Type parameter ",1,2,3,4,5,56,7);
	}
}
