package pack1;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Proper
{
	protected static Properties prop;
	static
	{
		prop = new Properties();
		try
		{
			prop.load(ClassLoader.getSystemResourceAsStream("r1.properties"));
			System.out.println(prop.toString());
		}
		catch(IOException exc){exc.printStackTrace(); System.out.println("Don't work ");}
	}
	
	public static String GetProperty(String sKey)
	{
		return prop.getProperty(sKey);
	}

}