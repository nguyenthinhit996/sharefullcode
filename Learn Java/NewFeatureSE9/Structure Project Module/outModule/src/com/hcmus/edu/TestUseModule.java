package com.hcmus.edu;

import com.sharefullcode.blogspot.CheckUtil;
import com.sharefullcode.blogspot.HelloWorld;

import moduleName1.com.sharefullcode.blogspot.WorkerInModuleOne;
import moduleName2.com.sharefullcode.blogspot.WorkerInModule2;


public class TestUseModule {
	
	public static void main(String[] args) {
		
		// Action two class with same one module helloWorldModule.
		HelloWorld aa= new HelloWorld();
		aa.functional1();
		
		CheckUtil check= new CheckUtil();
		System.out.println(check.isEmplty("sfds"));
		
		
		// use multi packages in a module
		WorkerInModuleOne workerInModule1= new WorkerInModuleOne();
		workerInModule1.functionalOne();
		
		WorkerInModule2 workerInModule2= new WorkerInModule2();
		workerInModule2.functionalOne();
	}
}
