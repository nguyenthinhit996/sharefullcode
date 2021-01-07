package com.sharefullcode.blogspot.app;

import java.lang.System.Logger.Level;

public class AppOne {
	
	private final static System.Logger LOGGER = System.getLogger(AppOne.class.getSimpleName());
	
	public static void main(String[] args) {
		LOGGER.log(Level.ALL, "ALL LOG");
		LOGGER.log(Level.DEBUG, "DEBUG LOG");
		LOGGER.log(Level.ERROR, "ERROR LOG");
		LOGGER.log(Level.INFO, "INFO LOG");
		LOGGER.log(Level.OFF, "OFF LOG");
		LOGGER.log(Level.TRACE, "TRACE LOG");
		LOGGER.log(Level.WARNING, "WARNING LOG");
	}
}
