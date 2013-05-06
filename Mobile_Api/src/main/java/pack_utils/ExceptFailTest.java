package pack_utils;

public class ExceptFailTest extends Throwable
{
	private static final long serialVersionUID = 1L;
	
	String sMessageText;
	public ExceptFailTest(String sMessage)
	{
		this.sMessageText = sMessage;
	}
	
	public String toString()
	{
		System.out.println();
		System.out.println(sMessageText);
		return "Тест провален, причина "+sMessageText;
	}
}
