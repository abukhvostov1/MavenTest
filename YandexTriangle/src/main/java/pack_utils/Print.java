package pack_utils;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class Print
{
		// печать
		public static <T> void print(T obj)
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);
			pw.println(obj);
		}
		
		// печать колекции
		public static void prcol(Collection<?> col)
		{
			Iterator<?> it;
			it = (Iterator<?>) col.iterator();
			while(it.hasNext())
			{
				print(it.next());
			}
		}

}
