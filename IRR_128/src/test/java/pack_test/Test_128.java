package pack_test;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack_page.Page_IrrMain;
import pack_page.Page_IrrPrivateOffice;
import pack_page.Page_LoginStargate;
import pack_page.Page_Stargate;
import pack_utils.ArrayListDataStep;
import pack_utils.ExceptFailTest;
import pack_utils.Proper;
import pack_utils.WriterLog;


public class Test_128 extends TestConstruct
{
	Page_LoginStargate pageLoginStargate = PageFactory.initElements(GetWebDriver(0), Page_LoginStargate.class);
	Page_Stargate pageStargate;
	Page_IrrMain pageIrr = PageFactory.initElements(GetWebDriver(1), Page_IrrMain.class); //test_128_1
	Page_IrrPrivateOffice pageIrrPrOf;
	Page_IrrMain pageIrr2 = PageFactory.initElements(GetWebDriver(2), Page_IrrMain.class); //test_128_2
	Page_IrrPrivateOffice pageIrrPrOf2;
	private String sIdAdvert;
	private ArrayListDataStep list;
	
	
	@BeforeTest
	public void TestBefore() throws ExceptFailTest
	{
		print("Start @BeforeTest");
		wLog = new WriterLog();
		wLog.SetUpWriterLog("Log_Result.html");
		lthe.GetWritterLog(wLog);
		list = new ArrayListDataStep();
		list.CheckListExists();
		print("End @BeforeTest");
	}
	
	@AfterTest
	public void TestAfter()
	{
		print("Start @AfterTest");
		print("End @AfterTest");
	}
	
	
	@Test(invocationCount = 1)
	@Parameters({ "sUrl", "sLogin", "sPassword", "sPasswordIrr", "sNumberSteps" })
	public void TestStart(String sUrl, String sLogin, String sPassword, String sPasswordIrr, String sNumberSteps) throws ExceptFailTest
	{
		print("Start @Test");
		
		try
		{
////////////////////////////////////////////////////////// Получаем номер шагов, если такого блока с номерами нет то выходим
			int j=0, k=0;
			
			//  Шаги 0 - 17     sNumberSteps=1
			//  Шаги 18 - 49    sNumberSteps=2
			//  Шаги 50 - 81    sNumberSteps=3
			//  Шаги 82 - 113   sNumberSteps=4
			//  Шаги 114 - 141  sNumberSteps=5
			//  Шаги 142 - 173  sNumberSteps=6
			//  Шаги 174 - 205  sNumberSteps=7
			//  Шаги 206 - 236  sNumberSteps=8
			
			switch(sNumberSteps) 
			{
			case "1":
				j=0; k=18;
				break;
			case "2":
				j=18; k=50;
				break;	
			case "3":
				j=50; k=82;
				break;
			case "4":
				j=82; k=114;
				break;
			case "5":
				j=114; k=142;
				break;
			case "6":
				j=142; k=174;
				break;
			case "7":
				j=174; k=206;
				break;
			case "8":
				j=206; k=237;
				break;
			default:
				print("Tеста с таким блоком номеров шагов " + sNumberSteps +" не существует. Номера блоков от 1 до 8");
				wLog.WriteString(2, "Tеста с таким блоком номеров шагов " + sNumberSteps +" не существует. Номера блоков от 1 до 8");
				throw new ExceptFailTest("Tеста с таким блоком номеров шагов " + sNumberSteps +" не существует. Номера блоков от 1 до 8");		
			}
			
			
			
////////////////////////////////////////////////////////	Заходим и удаляем все объявления , проверяем что удалено САЙТ //Пользователь 1
			
			print("Пользователь " + Proper.GetProperty("email"+sNumberSteps));
			wLog.WriteString(1, "Пользователь " + Proper.GetProperty("email"+sNumberSteps));
			pageIrr.GetWriterLog(wLog);
			pageIrr.OpenPage(sUrl);
			pageIrr.OpenFormAuthorization();
			pageIrrPrOf = pageIrr.LoginOn("email"+sNumberSteps, sPasswordIrr);
			
			pageIrrPrOf.GetWriterLog(wLog);
			pageIrrPrOf.DeleteAllAdvert(); //Удалям все объявления
			pageIrrPrOf.ReloadPage(true);
			pageIrrPrOf.GetStatusAndCategory(); // Значение всех счетчиков
			pageIrrPrOf.CheckAllCountersAfterChangeData("0", "0", "0", "0", "0", "0", "0", "0", "No", "No", "No", "No", "No", "No", "Удаление всех объявлений для " + Proper.GetProperty("email"+sNumberSteps));
	
////////////////////////////////////////////////////////////	Заходим и удаляем все объявления , проверяем что удалено САЙТ //Пользователь 2
			
		
			print("Пользователь " + Proper.GetProperty("email2"+sNumberSteps));
			wLog.WriteString(1, "Пользователь " + Proper.GetProperty("email2"+sNumberSteps));
			pageIrr2.GetWriterLog(wLog);
			pageIrr2.OpenPage(sUrl);
			pageIrr2.OpenFormAuthorization();
			pageIrrPrOf2 = pageIrr2.LoginOn("email2"+sNumberSteps, sPasswordIrr);
			
			pageIrrPrOf2.GetWriterLog(wLog);
			pageIrrPrOf2.DeleteAllAdvert(); //Удалям все объявления
			pageIrrPrOf2.ReloadPage(true);
			pageIrrPrOf2.GetStatusAndCategory(); // Значение всех счетчиков
			pageIrrPrOf2.CheckAllCountersAfterChangeData("0", "0", "0", "0", "0", "0", "0", "0", "No", "No", "No", "No", "No", "No", "Удаление всех объявлений для " + Proper.GetProperty("email2"+sNumberSteps));
			
			
	
///////////////////////////////////////////////////////// Создаем объявление БО
			
			pageLoginStargate.GetWriterLog(wLog);
			pageLoginStargate.OpenPage(sUrl+"/stargate/");
			pageLoginStargate.CheckElements();
			pageLoginStargate.TypeLoginPassword(sLogin, sPassword);
			pageStargate = pageLoginStargate.EnterStargate();
			pageStargate.GetWriterLog(wLog);
			pageStargate.OpenFormCreateAdvertAuto();
			pageStargate.InputDataAuto(sNumberSteps);		
			
////////////////////////////////////////////////////////////  Копируем ID объявления
			
			sIdAdvert = pageIrrPrOf.GetIdAdvert();
			//sIdAdvert = "248110901";
			print(sIdAdvert);		
			
////////////////////////////////////////////////////////////  Заходим в БО вносим изменения  Шаги
			
			
			
			
			//for(int i=j; i<list.GetSizeList(); i++)
			for(int i=j; i<k; i++)
			{
				int nAttemptReloadPageUserOne = 0;
				int nAttemptReloadPageUserTwo = 0;
				
				print("ШАГ " + i);
				wLog.WriteString(0, "ШАГ " + i);
				
				String sMas[] = list.GetList(i);
				//for(String s : sMas)
					//print(s);
			
				// 	emai_old - 0 	        // email_new - 1
				// 	changeOfRubric_old - 2  // changeOfRubric_new - 3
				//  region_old - 4          // region_new - 5	
				//  actionOfAdvert_old - 6	// actionOfAdvert_new - 7
				
				//  user_128_1 (шаг 0-17)
				//  sMyAdvert - 8 
				//  sAllStatus - 9 			// sActiveS - 10         	// sNotActiveS - 11
				//  sAllList - 12			// sNotActiveL - 13			// sActiveL - 14
				//	sAllCategory - 15		
				//  sMainAuto - 16			// sEasyCars - 17			// sUsedCars - 18
				//  sMainRealt - 19			// sRealtSell - 20			// sRealtSecond - 21
				//  nOperation - 22
				
				// 	user_128_2 (шаг 18-49;82-113;142-173;206-236)
				//  sMyAdvert - 23 
				//  sAllStatus - 24			// sActiveS - 25         	// sNotActiveS - 26
				//  sAllList - 27			// sNotActiveL - 28			// sActiveL - 29
				//	sAllCategory - 30		
				//  sMainAuto - 31			// sEasyCars - 32			// sUsedCars - 33
				//  sMainRealt - 34			// sRealtSell - 35			// sRealtSecond - 36
		
			
				pageStargate.OpenFindForm();
				pageStargate.FindAdvert(sIdAdvert);
				
				
				pageStargate.ChangeDataForAdvert(sMas[0]+sNumberSteps, sMas[1]+sNumberSteps, sMas[2], sMas[3], sMas[4], sMas[5], sMas[6], sMas[7], sMas[22],
						"изменение владельца объявления с " + Proper.GetProperty(sMas[0]+sNumberSteps).toUpperCase() + " на " + Proper.GetProperty(sMas[1]+sNumberSteps).toUpperCase() + "\r\n" +
						"изменение региона объявления с " + Proper.GetProperty(sMas[2]).toUpperCase() + " на " + Proper.GetProperty(sMas[3]).toUpperCase() + "\r\n" +
						"изменение рубрики объявления с " + Proper.GetProperty(sMas[4]).toUpperCase() + " на " + Proper.GetProperty(sMas[5]).toUpperCase() + "\r\n" +
						"изменение статуса активности объявления с " + Proper.GetProperty(sMas[6]).toUpperCase() + " на " + Proper.GetProperty(sMas[7]).toUpperCase());
				
				wLog.WriteString(0, "</br>");
///////////////////////////////////////////////////////	
				while(nAttemptReloadPageUserOne <=1)
				{
				
					if(nAttemptReloadPageUserOne == 1)
					{
						print("ПОВТОРНАЯ ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email"+sNumberSteps));
						wLog.WriteString(3, "ПОВТОРНАЯ ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email"+sNumberSteps));
					}
					else
					{
						print("ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email"+sNumberSteps));
						wLog.WriteString(3, "ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email"+sNumberSteps));
					}
					pageIrrPrOf.ReloadPage(true);
					pageIrrPrOf.GetStatusAndCategory(); // Значение всех счетчиков
					boolean bFlagUserOne = pageIrrPrOf.CheckAllCountersAfterChangeData(sMas[8], sMas[9], sMas[10], sMas[11], sMas[12], sMas[13], sMas[14], sMas[15], sMas[16], sMas[17], sMas[18], sMas[19], sMas[20], sMas[21], 
							"изменение владельца объявления с " + Proper.GetProperty(sMas[0]+sNumberSteps).toUpperCase() + " на " + Proper.GetProperty(sMas[1]+sNumberSteps).toUpperCase() + "\r\n" +
							"изменение региона объявления с " + Proper.GetProperty(sMas[2]).toUpperCase() + " на " + Proper.GetProperty(sMas[3]).toUpperCase() + "\r\n" +
							"изменение рубрики объявления с " + Proper.GetProperty(sMas[4]).toUpperCase() + " на " + Proper.GetProperty(sMas[5]).toUpperCase() + "\r\n" +
							"изменение статуса активности объявления с " + Proper.GetProperty(sMas[6]).toUpperCase() + " на " + Proper.GetProperty(sMas[7]).toUpperCase());
			
					if(!bFlagUserOne)
					{
						if((nAttemptReloadPageUserOne < 1))
						{	
							print("Счетчики для пользователя " + Proper.GetProperty("email"+sNumberSteps) + " некорректны, после первой загрузки страницы ЛК, перегружаем страницу через "+Proper.GetProperty("timeReloadPageFailCounter") + " милисекунд(ы)");
							wLog.WriteString(4, "Счетчики для пользователя " + Proper.GetProperty("email"+sNumberSteps) + " некорректны, после первой загрузки страницы ЛК, перегружаем страницу через "+Proper.GetProperty("timeReloadPageFailCounter") + " милисекунд(ы)");
							nAttemptReloadPageUserOne++;
						}
						else
							throw new ExceptFailTest("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
					}
					else
						nAttemptReloadPageUserOne = 2;
					
				}
				
				
				if( ((i > 17) && (i < 50)) || ((i > 81) && (i < 114)) || ((i > 141) && (i < 174)) || (i > 205))
				{
					while(nAttemptReloadPageUserTwo <=1)
					{
						wLog.WriteString(0, "</br>");
						
						if(nAttemptReloadPageUserTwo == 1)
						{
							print("ПОВТОРНАЯ ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email2"+sNumberSteps));
							wLog.WriteString(3, "ПОВТОРНАЯ ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email2"+sNumberSteps));
							pageIrrPrOf2.ReloadPage(true);
						}
						else
						{
							print("ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email2"+sNumberSteps));
							wLog.WriteString(3, "ПРОВЕРКА ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ " + Proper.GetProperty("email2"+sNumberSteps));
						}
						
						pageIrrPrOf2.ReloadPage(false);
						pageIrrPrOf2.GetStatusAndCategory(); // Значение всех счетчиков
						boolean bFlagUserTwo = pageIrrPrOf2.CheckAllCountersAfterChangeData(sMas[23], sMas[24], sMas[25], sMas[26], sMas[27], sMas[28], sMas[29], sMas[30], sMas[31], sMas[32], sMas[33], sMas[34], sMas[35], sMas[36], 
								"изменение владельца объявления с " + Proper.GetProperty(sMas[0]+sNumberSteps).toUpperCase() + " на " + Proper.GetProperty(sMas[1]+sNumberSteps).toUpperCase() + "\r\n" +
								"изменение рубрики объявления с " + Proper.GetProperty(sMas[2]).toUpperCase() + " на " + Proper.GetProperty(sMas[3]).toUpperCase() + "\r\n" +
								"изменение региона объявления с " + Proper.GetProperty(sMas[4]).toUpperCase() + " на " + Proper.GetProperty(sMas[5]).toUpperCase() + "\r\n" +
								"изменение статуса активности объявления с " + Proper.GetProperty(sMas[6]).toUpperCase() + " на " + Proper.GetProperty(sMas[7]).toUpperCase());
					
						if(!bFlagUserTwo)
						{
							if((nAttemptReloadPageUserTwo < 1))
							{	
								print("Счетчики для пользователя " + Proper.GetProperty("email2"+sNumberSteps) + " некорректны, после первой загрузки страницы ЛК, перегружаем страницу через "+Proper.GetProperty("timeReloadPageFailCounter") + " милисекунд(ы)");
								wLog.WriteString(4, "Счетчики для пользователя " + Proper.GetProperty("email2"+sNumberSteps) + " некорректны, после первой загрузки страницы ЛК, перегружаем страницу через "+Proper.GetProperty("timeReloadPageFailCounter") + " милисекунд(ы)");
								nAttemptReloadPageUserTwo++;
							}
							else
								throw new ExceptFailTest("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
						}
						else
							nAttemptReloadPageUserTwo = 2;
						
					}
					
				}
				
////////////////////////////////////////////////////////////////////////////////////				
				wLog.WriteString(0, "</br>");
				
			}

//////////////////////////////////////////////////////////////

		}
		catch(Exception exc)
		{
			print("Что то случилось непредвиденное");
			wLog.WriteString(2, "Что то случилось непредвиденное: "+exc.toString());
			exc.printStackTrace();
			throw new ExceptFailTest(exc.toString());
		}
		finally
		{
			CaptureScreenshot(driver[0], "screen1");
			CaptureScreenshot(driver[1], "screen2");
			CaptureScreenshot(driver[2], "screen3");
			wLog.CloseFile();
			driver[0].quit();
			driver[1].quit();
			driver[2].quit();
		}
		print("End @Test");
	
		
	}


	
}
