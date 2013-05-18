/**
 * 
 */
package org.pronto.core.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author abukhvostov
 *
 */
public class PropertiesReader {
	protected static Properties prop;
	static {
		prop = new Properties();
		try {
			prop.load(ClassLoader
					.getSystemResourceAsStream("config.properties"));
		} catch (IOException exc) {
			exc.printStackTrace();
			System.out.println("Can't read properties or properties problem");
		}
	}

	public static String getProperty(String sKey) {
		return prop.getProperty(sKey);
	} 
}
