package com.gcrapp.selenium.tests.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AppLogger {
	static {
		 PropertyConfigurator.configure("log4j.properties");
	}
	
	private Logger logger;

	public AppLogger(final Class<?> clazz) {
		logger = Logger.getLogger(clazz);
		
		
		
		
	}
	
	/*public static AppLogger getLogger(Class<?> clazz) {
		appLogger = new AppLogger(clazz);
		return appLogger;
	}*/
	
	public void info(String message) {
		if(logger.isInfoEnabled()){
			logger.info(message);
		}
	}
	
	public void debug(String message) {
		if(logger.isDebugEnabled()){
			logger.debug(message);
		}
	}
	
	public void warning(String message, Throwable error) {
		logger.warn(message,  error);
	}
	
	public void error(String message, Throwable error) {
		logger.error(message, error);
	}
}
