package pack_utils;

import java.util.Comparator;

public class Comp<T extends Number> implements Comparator<T>
{
	@Override
	public int compare(T o1, T o2)
	{
		int k;
		k = ((o1.doubleValue() - o2.doubleValue()) > 0)?1:( ((o1.doubleValue() - o2.doubleValue())== 0)?0 :-1);
		return k;
	}
	
}