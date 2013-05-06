package pack_utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListNameWebElement
{
	private HM<String,String> objHM; 
	
	public void LoadNameElements()
	{
		String s = null;
		objHM = new HM<String, String>();
		try
		{
			File f = new File("src/main/resource/NameElements.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br= new BufferedReader(fr);
			
			while ((s=br.readLine()) != null)
			{
				
				/*byte[] winData = s.getBytes("Cp1251");
				String string = new String(winData);
				System.out.println(string);
				*/
				String s1[] = s.split("&");
				objHM.SetValue(s1[0], s1[1]);
			}
			
			objHM.SetS();
		}
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e){e.printStackTrace();}
	}
	
	public String GetNameWebElement(String sByName)
	{
		return objHM.GetValue(sByName);
	}
	
	public void PrintNameWebElement()
	{
		objHM.PrintKeyAndValue();
	}
	

	
	
/*	class HM  
	{
	
		private HashMap<String, String> hm =new HashMap<String, String>();
		private Set<Map.Entry<String,String>> s;
		

		public void PrintKeyAndValue()
		{
			s = hm.entrySet();
			for(Map.Entry<String,String>me :s)
			{
				System.out.println(me.getKey()+" = "+me.getValue());
			}
		}
		
		public String GetValue(String sKey)
		{
			return hm.get(sKey);
		}
		
		public void SetValue(String sKey, String iValue)
		{
			hm.put(sKey, iValue);
		}
	}
	*/
}
