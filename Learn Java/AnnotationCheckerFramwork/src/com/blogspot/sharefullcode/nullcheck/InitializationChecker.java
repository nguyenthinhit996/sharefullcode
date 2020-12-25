package com.blogspot.sharefullcode.nullcheck;

import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class InitializationChecker {

	Object field1;
	Object field2;

	public InitializationChecker(String arg1) {
	      this.field1 = arg1;
	      init_other_fields();
	    }
 

	// A helper routine that initializes all the fields other than field1.
	@EnsuresNonNull({ "field2" })
	private void init_other_fields(@UnderInitialization InitializationChecker this) {
		field2 = new Object();
	}

	public static void main(String[] args) {
		InitializationChecker sss= new InitializationChecker("sdfs");
		 
	}
}
