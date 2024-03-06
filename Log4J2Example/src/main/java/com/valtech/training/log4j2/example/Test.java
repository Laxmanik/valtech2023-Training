package com.valtech.training.log4j2.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Log4J implementation

public class Test {
	
	private static final Logger LOGGER = LogManager.getLogger(Test.class);
	
	public static void processData() {
		//log methods with priorities
		LOGGER.trace("FROM TRACE METHOD");
		LOGGER.debug("FROM DEBUG METHOD");
		LOGGER.info("FROM INFO METHOD");
		LOGGER.warn("FROM WARN METHOD");
		LOGGER.error("FROM ERROR METHOD");
		LOGGER.fatal("FROM FATAL METHOD");
	}

	public static void main(String[] args) {
		processData();
	}
	
}