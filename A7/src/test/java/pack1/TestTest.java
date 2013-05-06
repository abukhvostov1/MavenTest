package pack1;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


class ExceptFailTest extends Throwable
{
	private static final long serialVersionUID = 1L;
	
	String sMessageText;
	public ExceptFailTest(String sMessage)
	{
		this.sMessageText = sMessage;
		System.out.println("Тест провален, причина "+sMessageText);
		assertTrue(false);
	}
	
	public String toString()
	{
		System.out.println(sMessageText);
		return "Тест провален, причина "+sMessageText;
	}
}
public class TestTest {
	boolean bFlag; 

  @Test
  //@Parameters({ "url" })
  public void Test(/*String url*/) throws ExceptFailTest
  {
	  WebDriver driver = new FirefoxDriver();
	 try 
	 {
	  	String s = Proper.GetProperty("url");
	  	System.out.println(s);
	  	System.out.println("Start Testng: "+ s);
	  	System.out.println("Start Test");
		driver.get(s);
		WebElement wElement = driver.findElement(By.id("uname2"));
		wElement.sendKeys("dfsdfsdfsd");
		driver.quit();
		System.out.println("Close Test");
		bFlag = true;
	}
	catch(Exception exc)
	{
		System.out.println("Что то случилось непредвиденное");
		
		exc.printStackTrace();
		System.out.println("перед ассертом");
		//assertTrue(false);
		System.out.println("после ассерта2");
		driver.quit();
		bFlag = false;
		if(!bFlag)
		fail("some error here2");
		//throw new ExceptFailTest(exc.toString());
	}	
  }
  
  /*@AfterMethod(alwaysRun=true)
  public void tearDown() throws Exception
  {
      if(!bFlag)
      fail("some error here2");
  }*/
  
  
  
}
