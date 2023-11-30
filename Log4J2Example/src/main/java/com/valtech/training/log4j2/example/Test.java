package com.valtech.training.log4j2.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Log4J implementation

public class Test {
	
	private static final Logger log = LogManager.getLogger(Test.class);
	
	public static void processData() {
		//log methods with priorities
		log.trace("FROM TRACE METHOD");
		log.debug("FROM DEBUG METHOD");
		log.error("FROM ERROR METOD");
		log.info("FROM INFO METOD");
		log.warn("FROM WARN METOD");
		log.fatal("FROM FATAL METOD");
	}

	public static void main(String[] args) {
		processData();
	}
	
}
