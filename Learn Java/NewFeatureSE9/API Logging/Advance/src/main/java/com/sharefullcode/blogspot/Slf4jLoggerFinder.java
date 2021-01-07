package com.sharefullcode.blogspot;

import java.lang.System.Logger;

public class Slf4jLoggerFinder extends System.LoggerFinder{

	@Override
	public Logger getLogger(String name, Module module) {
		return new Slf4jCustomImplementation(name);
	}
}
