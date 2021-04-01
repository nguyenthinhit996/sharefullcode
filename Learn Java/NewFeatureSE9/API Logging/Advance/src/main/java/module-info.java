module DemoApiLoggingWithLog4j2 {
	exports com.sharefullcode.blogspot.app;
	exports com.sharefullcode.blogspot;

	provides java.lang.System.LoggerFinder with 
	com.sharefullcode.blogspot.Slf4jLoggerFinder;
	
	requires org.slf4j;
}