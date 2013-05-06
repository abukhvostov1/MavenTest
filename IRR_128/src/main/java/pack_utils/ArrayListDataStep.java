package pack_utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListDataStep
{
	ArrayList<String>  list = new ArrayList<String>();
	String s;
	WriterLog wLog;
	
	public ArrayListDataStep()
	{
		try
		{
			File f = new File("src/main/resource/step128.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br= new BufferedReader(fr);
			
			while ((s=br.readLine()) != null)
			{
				list.add(s);	
			}
		fr.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e){e.printStackTrace();}
	}
	
	public void CheckListExists() throws ExceptFailTest
	{
		if(list.size() == 0)
		{
			System.out.println("Не удалось загрузить данные по шагам теста (файл step128.txt)");
			wLog.WriteString(2, "Не удалось загрузить данные по шагам теста (файл step128.txt)");
			throw new ExceptFailTest("Не удалось загрузить данные по шагам теста (файл step128.txt)");
		}
	}
	
	
	public String[] GetList(int index) throws ExceptFailTest
	{	
			String sMas[] = list.get(index).split(";");
			return sMas;
	}
	
	public int GetSizeList()
	{
		return list.size();
	}
	
	
}
