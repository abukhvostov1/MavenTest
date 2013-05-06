package pack_utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/*public class StatusAdvert
{
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	Set<Map.Entry<String,Integer>> s;
	
	public StatusAdvert(String masS[], Integer masI[])
	{
		int i = masS.length;
		for(int j=0; j<i; j++)
		{
			hm.put(masS[j], masI[j]);
		}
		s = hm.entrySet();
	}
	
	public void PrintKeyAndValue()
	{
		for(Map.Entry<String,Integer>me :s)
		{
			System.out.println(me.getKey()+" = "+me.getValue());
		}
	}
	
	public int GetValue(String sKey)
	{
		return hm.get(sKey);
	}
	
	public void SetValue(String sKey, Integer iValue)
	{
		hm.put(sKey, iValue);
	}
	
	
}*/

public class HM<K,V>
{
	private HashMap<K, V> hm;
	private Set<Entry<K,V>> s;

	
	public HM() 
	{
		hm=new HashMap<K, V>();
	}
	
	public HM(K masK[], V masV[]) 
	{
		hm = new HashMap<K, V>();
		int i = masK.length;
		for(int j=0; j<i; j++)
		{
			hm.put(masK[j], masV[j]);
		}
		s = hm.entrySet();
	}
	
	public void SetS()
	{
		s = hm.entrySet();
	}
	
	public void PrintKeyAndValue()
	{
		
		for(Map.Entry<K,V>me :s)
		{
			System.out.println(me.getKey()+" = "+me.getValue());
		}
	}
	
	public void PrintKeyAndValue(WriterLog wLogIn) throws ExceptFailTest
	{
		WriterLog wLog = wLogIn;
		for(Map.Entry<K,V>me :s)
		{
			wLog.WriteString(1, me.getKey()+" = "+me.getValue());
			System.out.println(me.getKey()+" = "+me.getValue());
		}
	}
	
	
	public V GetValue(K sKey)
	{
		return hm.get(sKey);
	}
	
	public void SetValue(K kKey, V vValue)
	{
		hm.put(kKey, vValue);
	}
}
