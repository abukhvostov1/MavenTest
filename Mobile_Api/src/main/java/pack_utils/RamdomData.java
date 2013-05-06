package pack_utils;

import java.util.Random;

public final class RamdomData
{
	protected static Random r;
	static
	{
		r = new Random();
	}
	
	public static String GetRamdomString(int lenth)
	{
		char mas[] = new char[lenth];
		for(int i=0; i<lenth; i++)
		{
			mas[i] = (char)(r.nextInt(25)+97);
		}
		String s = new String(mas);
		return s;
	}
	
	public static String  GetRandomData(String sMassData, String sCurrentData)
	{
		String mas[] = sMassData.split("&");
		String sData = "";
		do
		{
			int i = r.nextInt(mas.length);
			sData = mas[i];
		}
		while(sData.equals(sCurrentData));
		return sData;
		
	}
	
	
}
