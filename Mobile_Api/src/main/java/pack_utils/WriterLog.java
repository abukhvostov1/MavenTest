package pack_utils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterLog
{
	private File file;
	private FileWriter fw;
	
	
	public void SetUpWriterLog(String sPath) throws ExceptFailTest
	{
		try
		{
			file = new File(sPath); 
			fw = new FileWriter(file);
		}
		catch(NullPointerException exc)
		{
			System.out.println("Не удалось создать файл лога");
			throw new ExceptFailTest("Не удалось создать файл лога");
		}
		catch(IOException exc)
		{
			System.out.println("Не удалось создать файл лога");
			throw new ExceptFailTest("Не удалось создать файл лога");
		}
		System.out.println("Создаем файл лога");
		//charset=utf-8
		WriteString(0, "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;\"><title>Log_Result</title></head>");
		WriteString(0, "<body style=\"background-color:Linen\">");
		WriteString(0, "<style type=\"text/css\">table {width: 100%;}td {border: 1px solid;padding: 5px 10px;width: 50%;vertical-align: top;}</style>");
		WriteString(0, "<style> pre {margin:0;padding:0; font-family:arial; font: arial 18px/16px;} </style>");
		WriteString(0, "<style type=\"text/css\">" +
				"input[type=checkbox] {position: absolute;margin-top: -26px;}" +
				"label {margin: 0 0 10px 25px;display: block;cursor: pointer;font-size: 18px;font-weight: bold;}" +
				".wrap {position: relative;}" +
				".text {color: white;display: none;}" +
				"input[type=checkbox]:checked + .text {display: block;}" +
				"</style>");
	}
	
	
	public void WriteString(int iTypeOfString, String sMessage) throws ExceptFailTest
	{
		try
		{
			switch(iTypeOfString)
			{
				case 1:
					System.out.println(sMessage);
					fw.write("<pre style=\"color:green\">" + sMessage + "</pre>"+"\n");
					break;
				case 2:
					System.out.println(sMessage);
					WriteNewStepEnd();
					fw.write("<pre  style=\"color:red; padding-top:25px;\">" + sMessage + "</pre>"+"\n");
					break;
				case 3:
					System.out.println(sMessage);
					fw.write("<pre style=\"color:blue\">" + sMessage + "</pre>"+"\n");
					break;
				case 4:
					System.out.println(sMessage);
					fw.write("<h1>" + sMessage + "</h1>");
					break;
				case 5:
					System.out.println(sMessage);
					fw.write("<pre style=\"color:black\">" + sMessage + "</pre>"+"\n");
					break;
				default:
					fw.write(sMessage + "\n");
					break;
			}
		}
		catch(IOException exc)
		{
			System.out.println("Не удалось записать в файл лога: " + sMessage);
			throw new ExceptFailTest("Не удалось записать в файл лога: " + sMessage);
		}
	}
	
	
	public void  WriteNewStepBegin(String sNameStep, int nToogle) throws ExceptFailTest
	{
		System.out.println(sNameStep);
		WriteString(0, "<div class=\"wrap\">");
		WriteString(0, "<label for=\"toggle-" + nToogle + "\">" +sNameStep + "</label>");
		WriteString(0, "<input type=\"checkbox\" id=\"toggle-" + nToogle + "\">");
		WriteString(0, "<div class=\"text\">");
		
	}
	
	public void WriteNewStepEnd() throws ExceptFailTest
	{
		WriteString(0, "</div></div>");
		WriteString(0, "<hr>");
	}
	
	public void WriteHr() throws ExceptFailTest
	{
		WriteString(0, "<hr>");
	}
	

	
	public void WriteNewTable(String sLeftText, String sRightText, String sName, String sName2, int nToogle, int nToogle2) throws ExceptFailTest
	{
		WriteString(0, "<table><tr><td>");
		WriteString(0, "<div class=\"wrap\"><label for=\"toggle-" + nToogle + "\">"+ sName +"</label>");
		WriteString(0, "<input type=\"checkbox\" id=\"toggle-" + nToogle + "\">");
		WriteString(0, "<div class=\"text\"><pre style=\"color:black\">" + sLeftText + "</pre></div></div>");
		WriteString(0, "</td><td>");
		WriteString(0, "<div class=\"wrap\"><label for=\"toggle-" + nToogle2 + "\">"+ sName2 +"</label>");
		WriteString(0, "<input type=\"checkbox\" id=\"toggle-" + nToogle2 + "\">");
		WriteString(0, "<div class=\"text\"><pre style=\"color:black\">" + sRightText + "</pre></div></div>");
		WriteString(0, "</td></tr></table>");
	}
	
	public void CloseFile() throws ExceptFailTest
	{
		WriteString(0, "</div></div>");
		WriteString(0, "</body></html>");
		System.out.println("Закрываем файл лога");
		try {fw.close();} 
		catch (IOException exc){System.out.println("Не удалось закрыть файл лога");}
	}
}
