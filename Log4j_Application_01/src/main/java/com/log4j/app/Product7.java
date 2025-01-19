package com.log4j.app;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Product7 {
	
	private static Logger log = Logger.getLogger(Product7.class);

	public static void main(String[] args) throws Exception{
		
		// Define a pattern for the log messages
		String pattern = "%d{yyyy-MM-dd HH:mm:ss} [%p] %c - %m%n"; // Date, log level, logger name, message, newline


        Layout layout = new PatternLayout(pattern);
        Appender appender = new FileAppender(layout,"myapp_withPatternLayout_FileAppender.log");
        log.addAppender(appender);
        
        log.debug("DEBUG priority method is used to print message with data or print final result like : Mohit id :101");
		log.info("INFO priority method is used to print simple message like connection create, email sent...etc");
		log.warn("WARN priority method is used to print Warning message like resource not close, local variable not used...etc");
		log.error("ERROR priority method is used to print exception message like : nullpointerexception, arrayIndex...etc");
		log.fatal("FATAL priority method is used to print high level problem like : server down, network break...etc");
	}

}
