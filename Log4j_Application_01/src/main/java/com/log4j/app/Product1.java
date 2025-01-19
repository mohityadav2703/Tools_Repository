/**
 * 	Appender : ConsoleAppender
 * 	Layout	 : HtmlLayout
 */

package com.log4j.app;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;

public class Product1 {

	private static Logger log = Logger.getLogger(Product1.class);
	
	public static void main(String[] args) {
		
		Layout layout = new HTMLLayout();
		Appender appender = new ConsoleAppender(layout);
		
		log.addAppender(appender);
		log.debug("DEBUG priority method is used to print message with data or print final result like : Mohit id :101");
		log.info("INFO priority method is used to print simple message like connection create, email sent...etc");
		log.warn("WARN priority method is used to print Warning message like resource not close, local variable not used...etc");
		log.error("ERROR priority method is used to print exception message like : nullpointerexception, arrayIndex...etc");
		log.fatal("FATAL priority method is used to print high level problem like : server down, network break...etc");
		
	}

}
