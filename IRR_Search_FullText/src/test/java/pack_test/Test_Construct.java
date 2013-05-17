package pack_test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import pack_utils.ListenerThatHiglilightsElements;
import pack_utils.Proper;



public class Test_Construct
{
	protected WebDriver driver;
	protected EventFiringWebDriver event_driver;
	
	private FirefoxProfile GetFireFoxProfile(int n)
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.http.use-cache", false);
		profile.setPreference("permissions.default.image", n); // не грузим изображения если = 2
		profile.setPreference("dom.ipc.plugins.enabled", false); 
		//profile.setPreference("webdriver.load.strategy", "unstable"); 
		return profile;
	}
	 
	
	public WebDriver GetWebDriver(int n)
	{
		if(driver==null)
		{
			driver = new FirefoxDriver(GetFireFoxProfile(n));
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS); // время ожидания загрузки страницы(если превышено выкидывается ошибка)
			if(Proper.GetProperty("lightElement").equals("yes"))  // используем ли драйвер слушатель
			{
				event_driver = new EventFiringWebDriver(this.driver);
				event_driver.register(new ListenerThatHiglilightsElements("#FFFF00", 1, 250, TimeUnit.MILLISECONDS));
				return event_driver;
			}
			else
			{
				return driver;
			}
		}
		else 
		{
			if(Proper.GetProperty("lightElement").equals("yes"))
				return event_driver;
			else
				return driver;				
		}
	}
	
	public <T> void print(T obj)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(obj);
	}
	
	
	// Снятие скриншота
	protected void CaptureScreenshot(String sName)
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "src\\" + screenshot.getName();
		System.out.println(path);

		try 
		{
			FileUtils.copyFile(screenshot, new File(/*"src\\" + */  sName + ".png"));
		}
		catch (IOException e){print("Не удалось создать скриншот");}
	}
}
