package StreetFighterPackage.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	private static ResourceBundle rb =  ResourceBundle.getBundle("config");  //Reading the config.properties file
	public static String getValue(String key) {
		return rb.getString(key);
		
	} // Method reading values based on key passed

}
