package com.sharefullcode.blogspot.loging;

import java.lang.System.Logger;

public class ConsologerFinder extends System.LoggerFinder{

	@Override
	public Logger getLogger(String name, Module module) {
		return new Consologer();
	}

}
