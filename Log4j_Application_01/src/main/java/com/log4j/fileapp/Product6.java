package com.log4j.fileapp;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

public class Product6 {

	private static Logger log = Logger.getLogger(Product6.class);
	
	public static void main(String[] args) throws Exception{
		Layout layout = new XMLLayout();
		Appender appender = new FileAppender(layout,"myapp_withXmlLayout_FileAppender.log");
		log.addAppender(appender);
		
		log.debug("DEBUG priority method is used to print message with data or print final result like : Mohit id :101");
		log.info("INFO priority method is used to print simple message like connection create, email sent...etc");
		log.warn("WARN priority method is used to print Warning message like resource not close, local variable not used...etc");
		log.error("ERROR priority method is used to print exception message like : nullpointerexception, arrayIndex...etc");
		log.fatal("FATAL priority method is used to print high level problem like : server down, network break...etc");

	}

}
