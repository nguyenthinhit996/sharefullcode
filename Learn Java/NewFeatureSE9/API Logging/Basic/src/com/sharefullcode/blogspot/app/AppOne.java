package com.sharefullcode.blogspot.app;

import java.lang.System.Logger.Level;

public class AppOne {
	
	static System.Logger LOGGER = System.getLogger(AppOne.class.toString());

	public static void main(String[] args) {
		LOGGER.log(Level.INFO, "Test");
		LOGGER.log(Level.ERROR, "error test");
		abc();
	}
	
	static void abc() {
		LOGGER.log(Level.INFO, "Test");
		LOGGER.log(Level.ERROR, "error test");
	}	
}
