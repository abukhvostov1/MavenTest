package pack_test;
import pack_page.Page_IrrMain;
import pack_page.Page_IrrPrivateOffice;
import pack_page.Page_LoginStargate;
import pack_page.Page_Stargate;
import pack_utils.ExceptFailTest;
import pack_utils.HM;
import pack_utils.Proper;
import pack_utils.ResultTest;
import pack_utils.WriterLog;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCount extends TestConstruct
{

	Page_LoginStargate pageLoginStargate = PageFactory.initElements(GetWebDriver(), Page_LoginStargate.class);
	Page_Stargate pageStargate;
	Page_IrrMain pageIrr = PageFactory.initElements(GetWebDriver(), Page_IrrMain.class);
	Page_IrrPrivateOffice pageIrrPrOf;
	HM<String, Integer> clStatusAdvert; // Статус
	HM<String, Integer> clStatusAdvertCategory; //Категории
	WriterLog wLog;//Лог
	ResultTest testR;
	
	@BeforeTest
	public void befTest() throws ExceptFailTest
	{
		System.out.println("Start @BeforeTest");
		testR = new ResultTest();
		wLog = new WriterLog();
		wLog.SetUpWriterLog("Log_Result.html");
		lthe.GetWritterLog(wLog);
		System.out.println("End @BeforeTest");
	};
	
	@AfterTest(alwaysRun=true)
	public void aftTest()
	{
		System.out.println("Start @AfterTest");
		//if(!testR.GetFlag())
		//fail("some error here");
		System.out.println("End @AfterTest");
	}
	
	@Test
	public void TestStart() throws ExceptFailTest
	{
		
		System.out.println("Start @Test");
		try
		{
			pageLoginStargate.GetWriterLog(wLog); // отдали лог
			pageLoginStargate.OpenPage();
			pageLoginStargate.CheckElements();
			pageLoginStargate.TypeLoginPassword();
			pageStargate = pageLoginStargate.EnterStargate();
			pageStargate.GetWriterLog(wLog);
			
			if(Proper.GetProperty("typeAdvert").equals("premium"))
				pageStargate.OpenFormCreatePremiumAuto();
			else
				pageStargate.OpenFormCreateAdvertAuto();
			pageStargate.InputDataAuto();
			
			if(Proper.GetProperty("typeAdvert").equals("premium"))
				pageStargate.OpenFormCreatePremiumFree();
			else
				pageStargate.OpenFormCreateAdvertFree();
			pageStargate.InputDataFree();
			
			pageIrr.GetWriterLog(wLog);
			pageIrr.OpenPage();
			pageIrr.OpenFormAuthorization();
			pageIrrPrOf = pageIrr.LoginOn();
			pageIrrPrOf.GetWriterLog(wLog);
	
			
			pageIrrPrOf.CheckCountAndVisibleAdvert();
			pageIrrPrOf.CheckCurrentCategory();
			pageIrrPrOf.GetCurrentStatus();
			pageIrrPrOf.GetCurrentCategory();
			pageIrrPrOf.DeactivateAllAdvert();
			pageIrrPrOf.CheckCountAndVisibleAdvert();
			pageIrrPrOf.CheckCurrentCategory();
			pageIrrPrOf.CheckOldAndNewStatus(1);
			pageIrrPrOf.CheckOldAndNewCategory(1);
			pageIrrPrOf.DeleteAllAdvert();
			pageIrrPrOf.CheckCountAndVisibleAdvert();
			pageIrrPrOf.CheckCurrentCategory();
			pageIrrPrOf.CheckOldAndNewStatus(2);
		
			clStatusAdvert = pageIrrPrOf.SendStatus();
			clStatusAdvertCategory = pageIrrPrOf.SendCategory();
			pageIrrPrOf.LogOutFromIrr();
			
			
			pageLoginStargate.OpenPage();
			pageLoginStargate.CheckElements();
			pageLoginStargate.TypeLoginPassword();
			pageStargate = pageLoginStargate.EnterStargate();
			pageStargate.GetWriterLog(wLog);
			
			if(Proper.GetProperty("typeAdvert").equals("premium"))
				pageStargate.OpenFormCreatePremiumAuto();
			else
				pageStargate.OpenFormCreateAdvertAuto();
			pageStargate.InputDataAuto();
			
			if(Proper.GetProperty("typeAdvert").equals("premium"))
				pageStargate.OpenFormCreatePremiumFree();
			else
				pageStargate.OpenFormCreateAdvertFree();
			pageStargate.InputDataFree();
			
			pageIrr.OpenPage();
			pageIrr.OpenFormAuthorization();
			pageIrrPrOf = pageIrr.LoginOn();
			pageIrrPrOf.GetWriterLog(wLog);
			
			pageIrrPrOf.GetStatusForLastLogin(clStatusAdvert, clStatusAdvertCategory);
			
			pageIrrPrOf.CheckCountAndVisibleAdvert();
			pageIrrPrOf.CheckCurrentCategory();
			
			pageIrrPrOf.CheckOldAndNewStatus(3);  
			pageIrrPrOf.CheckOldAndNewCategory(2);
			System.out.println("Тест завершен успешно");
			wLog.WriteString(1, "Тест завершен успешно");
		}
		catch(ExceptFailTest exc)
		{
			System.out.println("Что то случилось непредвиденное 2" +exc.toString());
			wLog.WriteString(2, "Что то случилось непредвиденное 2: "+exc.toString());
			fail("some error here2");
			//testR.SetFlag(false);
		}
		catch(Exception exc)
		{
			System.out.println("Что то случилось непредвиденное" +exc.toString());
			wLog.WriteString(2, "Что то случилось непредвиденное: "+exc.toString());
			fail("some error here");
			//testR.SetFlag(false);
			//throw new ExceptFailTest(exc.toString());
		}
		
		finally
		{
			CaptureScreenshot();
			wLog.CloseFile();
			driver.quit();
		}
		System.out.println("End @Test");
	}
	
}
