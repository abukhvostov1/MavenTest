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
import pack_utils.WriterLog;


public class TestConstruct
{
	protected WebDriver driver[] = new FirefoxDriver[3];
	protected EventFiringWebDriver driver1[] = new EventFiringWebDriver[3];
	protected ListenerThatHiglilightsElements lthe;
	protected WriterLog wLog;
	
	@SuppressWarnings("unused")
	private FirefoxProfile GetFireFoxProfile()
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.http.use-cache", false);
		return profile;
	}
	
		
	public WebDriver GetWebDriver(int nDriver)
	{
		
		if((driver[0] == null) || (driver[1] == null)|| (driver[2] == null))
		{
			driver[0] = new FirefoxDriver(/*GetFireFoxProfile()*/);
			driver[1] = new FirefoxDriver(/*GetFireFoxProfile()*/);
			driver[2] = new FirefoxDriver(/*GetFireFoxProfile()*/);
			driver[0].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver[1].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver[2].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			lthe = new ListenerThatHiglilightsElements("#FFFF00", 1, 250, TimeUnit.MILLISECONDS);
			if(Proper.GetProperty("lightElement").equals("yes"))
			{
				driver1[0] = new EventFiringWebDriver(this.driver[0]);
				driver1[1] = new EventFiringWebDriver(this.driver[1]);
				driver1[2] = new EventFiringWebDriver(this.driver[2]);
				driver1[0].register(lthe);
				driver1[1].register(lthe);
				driver1[2].register(lthe);
				driver1[0].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver1[1].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver1[2].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if(nDriver == 0)
					return driver1[0];
				if(nDriver == 1)
					return driver1[1];
				return driver1[2];
			}
			else
			{
				driver[0].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver[1].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver[2].manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if(nDriver == 0)
					return driver[0];
				if(nDriver == 1)
					return driver[1];
				return driver[2];
			}
		}
		else 
		{
			if(Proper.GetProperty("lightElement").equals("yes"))
			{
				if(nDriver == 0)
					return driver1[0];
				if(nDriver == 1)
					return driver1[1];
				return driver1[2];
			}
			else
			{
				if(nDriver == 0)
					return driver[0];
				if(nDriver == 1)
					return driver[1];
				return driver[2];
			}
		}
	}
	
	public void CaptureScreenshot(WebDriver wDriver, String sName)
	{
		File screenshot = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
        String path = "src\\" + screenshot.getName();
        System.out.println(path);
       
        try
        {
            FileUtils.copyFile(screenshot, new File(sName+".png"));
        } 
        catch (IOException e) {e.printStackTrace();}
    }
	
	public <T> void print(T obj)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(obj);
	}
	
	
}
