package pack_utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileReaderSuggest
{
	private static <T> void print(T obj)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(obj);
	}
	
	private static <T> ArrayList<String> print_mass(T obj[], ArrayList<String> col)
	 {
		for(T t : obj)
		{
			if(t.toString().length() > 1)
				col.add(t.toString());
		}
		for(int i=0; i<col.size(); i++)
			print(col.get(i));
		return col;
	}
	
	public static ArrayList<String> ReadFile() throws IOException
	{
		ArrayList<String> ar = new ArrayList<String>();
		String s;
		try(FileInputStream is = new FileInputStream("SuggestList.txt"))
		{
			byte b[] = new byte[is.available()];
			is.read(b, 0, b.length);
			s = new String(b, "utf8");	
		}
		String mas[] = s.split("\r\n| ");
		print("Слова по которым будет производиться поиск саджестов");
		print_mass(mas, ar);
		return ar;
	}
}
