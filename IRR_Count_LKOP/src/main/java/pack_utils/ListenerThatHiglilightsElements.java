package pack_utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class ListenerThatHiglilightsElements extends AbstractWebDriverEventListener {
	
	private long interval;
    private final int count;
    private final String color;
    private By lastFindBy;
    private WriterLog wLog;
    
    private ListNameWebElement lNameWebElement;

    public void GetWritterLog(WriterLog wLog)
    {
    	this.wLog = wLog;
    }
    
    
    public ListenerThatHiglilightsElements(int count, long interval, TimeUnit unit) {
        this("#FFFF00", count, interval, unit);
    }

    public ListenerThatHiglilightsElements(String color, int count, long interval, TimeUnit unit)
    {
        this.color = color;
        this.count = count;
        this.interval = TimeUnit.MILLISECONDS.convert(Math.max(0, interval), unit);
        lNameWebElement = new ListNameWebElement();
        lNameWebElement.LoadNameElements();
        
    }

    public void beforeFindBy(By by, WebElement element, WebDriver selenium){
        lastFindBy = by;
    }
    
    
    @Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		//flash(element, driver);
	}

    public void afterFindBy(By by, WebElement element,WebDriver driver)
    {
    	//System.out.println("Выполняется подсветка"+ driver.findElement(by).getText());
    	//flash2(by, driver);
    }
    
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver)
	{
		
	}
	
	public void onException(Throwable throwable, WebDriver driver)
	{
		if (throwable.getClass().equals(NoSuchElementException.class))
		{
			//System.out.println(lastFindBy.toString());
			if(lastFindBy.toString().equals("By.xpath: //div[contains(@class,'x-trigger-wrap-focus')]/img"))
				return;
			if(lastFindBy.toString().equals("By.xpath: //input[contains(@class,'x-form-focus')]"))
				return;
			if(lastFindBy.toString().equals("By.xpath: //select[contains(@class,'x-form-focus')]"))
				return;
			if(lastFindBy.toString().equals("By.xpath: //textarea[contains(@class, 'x-form-focus')]"))
				return;
			if(lastFindBy.toString().equals("By.xpath: //div[@class='x-combo-list-inner']/div[contains(text(),'Бийск')]"))
				return;
			try
			{
				System.out.println("Элемент "+lNameWebElement.GetNameWebElement(lastFindBy.toString())+" не найден");
				wLog.WriteString(2, "Элемент "+lNameWebElement.GetNameWebElement(lastFindBy.toString())+" не найден. ");
			}
			catch (ExceptFailTest e)
			{
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++)
		{
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}
	
	@SuppressWarnings("unused")
	private void flash2(By by, WebDriver driver)
	{	
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++) 
		{
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}
	
	
	//#FF0000 

	private void changeColor(String color, WebElement element, JavascriptExecutor js)
	{
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try 
		{
			Thread.sleep(interval);
		}
		catch (InterruptedException exc)
		{
			exc.printStackTrace();
		}
	}

}