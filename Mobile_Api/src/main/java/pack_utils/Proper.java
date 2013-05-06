package pack_utils;

import java.io.IOException;
import java.util.Properties;


public class Proper
{
	protected static Properties prop;
	static
	{
		prop = new Properties();
		try
		{
			prop.load(ClassLoader.getSystemResourceAsStream("conf.properties"));
			if(prop == null)
				System.out.println("Не удалось загрузить файл конфигурации");
		}
		catch(IOException exc){exc.printStackTrace(); System.out.println("Не удалось загрузить файл конфигурации");}
	}
	
	public static String GetProperty(String sKey)
	{
		return prop.getProperty(sKey);
	}
}