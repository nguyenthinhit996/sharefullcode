module CustomImplementLogger {
	provides java.lang.System.LoggerFinder
    with com.sharefullcode.blogspot.loging.ConsologerFinder;
	exports com.sharefullcode.blogspot.app;
}