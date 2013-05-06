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
    


    public ListenerThatHiglilightsElements(int count, long interval, TimeUnit unit)
    {
        this("#FFFF00", count, interval, unit);
    }

    public ListenerThatHiglilightsElements(String color, int count, long interval, TimeUnit unit)
    {
        this.color = color;
        this.count = count;
        this.interval = TimeUnit.MILLISECONDS.convert(Math.max(0, interval), unit);   
    }

    public void beforeFindBy(By by, WebElement element, WebDriver selenium){
        lastFindBy = by;
    }
    
    
    @Override
	public void beforeClickOn(WebElement element, WebDriver driver) 
    {
    	flash2(element,driver);
    }

    public void afterFindBy(By by, WebElement element,WebDriver driver)
    {
    	flash(by,driver);
    }
    
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver){}
	
	// если не был найден элемент
	public void onException(Throwable throwable, WebDriver driver)
	{
		/*if (throwable.getClass().equals(NoSuchElementException.class))
		{
			System.out.println(lastFindBy.toString());
		}*/
	}

	// изменение цвета
	private void flash(By by, WebDriver driver)
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
	
	
	private void flash2(WebElement element, WebDriver driver)
	{	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++) 
		{
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}
	
	// зменение цвета бекграунда под элементом
	private void changeColor(String color, WebElement element, JavascriptExecutor js)
	{
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
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