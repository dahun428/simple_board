package com.simple.util;

import java.io.FileInputStream;
import java.util.Properties;



public class QueryUtil {

	private static Properties prop = new Properties();

	static {
		try {
			
			prop.load(Class.forName("com.simple.util.QueryUtil").getResourceAsStream("query.properties"));
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static String getSQL(String name) {
		return prop.getProperty(name);
	}
		
	
}
