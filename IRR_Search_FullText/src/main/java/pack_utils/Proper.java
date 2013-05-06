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
			prop.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		}
		catch(IOException exc)
		{
			exc.printStackTrace(); 
			System.out.println("Не удалось загрузить файл конфигурации"); // здесь валить тест
		}
	}
	
	public static String GetProperty(String sKey)
	{
		return prop.getProperty(sKey);
	}
}

