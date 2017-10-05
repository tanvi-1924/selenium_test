/*package com.gcrapp.selenium.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderWriter {
	
	ConfigReaderWriter(){
		loadConfig();
	}

	public static final String filepath="/config.properties";
	public static Properties properties=new Properties();
			
	public static void loadConfig(){
		try {
			properties.load(new FileInputStream(filepath));
			System.out.println(properties.get("GECKO_DRIVER_LOCATION"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static String getProperty(String key){
		properties.get(key);
		return key;
	}
}

*/

package com.gcrapp.selenium.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderWriter {

	private static final String FILEPATH= "target/test-classes/config.properties";
	
	private static final Properties properties=new Properties();

	static{
		loadConfig();
	}  

	private ConfigReaderWriter(){
		//Not needed because you are not initializing the class and directly accessing getProperty.
		//loadConfig();
	}

	private static void loadConfig(){
		if(properties==null || properties.size()==0){
			try {
				properties.load(new FileInputStream(FILEPATH));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getProperty(String key){
		//loadConfig();
		return (String) properties.get(key);
	}
}

