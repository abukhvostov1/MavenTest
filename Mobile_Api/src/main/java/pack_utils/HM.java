package pack_utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class HM<K,V>
{
	private LinkedHashMap<K, V> hm;
	private Set<Entry<K,V>> s;

	
	public HM() 
	{
		hm=new LinkedHashMap<K, V>();
	}
	
	public HM(K masK[], V masV[]) 
	{
		hm = new LinkedHashMap<K, V>();
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
		s = hm.entrySet();
		for(Map.Entry<K,V>me :s)
		{
			System.out.println(me.getKey()+"="+me.getValue());
		}
	}
	
	public String GetStringFromAllHashMap()
	{
		if(hm.size()==0)
			return "";
		
		StringBuffer sBuff = new StringBuffer();
		s = hm.entrySet();
		for(Map.Entry<K,V>me :s)
		{
			sBuff.append(me.getKey()+"="+me.getValue()+",");
		}
		int n = sBuff.lastIndexOf(",");
		sBuff.deleteCharAt(n);
		String sT = new String(sBuff);
		sT = "{"+sT+"}";
		return sT;
	}
	
	
	public V GetValue(K sKey)
	{
		return hm.get(sKey);
	}
	
	public void SetValue(K kKey, V vValue)
	{
		hm.put(kKey, vValue);
	}
	
	public void DeletePos(K kKey)
	{
		hm.remove(kKey);
		
	}
	
	public int GetSize()
	{
		return hm.size();
	}
	
	public Set<K> GetAllKeys()
	{
		Set<K> sK = hm.keySet();
		return sK;
	}
	
	public boolean ContainsKeys(K kKey)
	{
		return hm.containsKey(kKey);
	}
	
}
