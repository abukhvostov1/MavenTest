package pack_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import pack_utils.ExceptFailTest;
import pack_utils.HM;
import pack_utils.Proper;


public class Page_IrrPrivateOffice extends Page
{
	@FindBy(id="checkAll")
	private WebElement wCheckBoxCheckAll;
	
	@FindBy(id="groupActionDeleteSelected")
	private WebElement wLinkDeleteSelected;
	
	@FindBy(id="groupActionDeactivateSelected")
	private WebElement wLinkDeactivateSelected;
	
	// Статус
	@FindBy(xpath="//div[@id='minWidth']//li[@class='all'][1]/div[2]")
	private WebElement wTextAllStatus;
	
	@FindBy(xpath="//div[@id='minWidth']//li[2]/a/div")
	private WebElement wLinkActiveStatus;
	
	@FindBy(xpath="//div[@id='minWidth']//li[3]/a/div")
	private WebElement wLinkNotActiveStatus;
	
	// Категории
	@SuppressWarnings("unused")
	@FindBy(xpath="//div[@class='b-blockInf'][2]//li[@class='all']/div[2]")
	private WebElement wTextAllCategory;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div")
	private WebElement wTextLinkAutoAndMoto;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/']/div")
	private WebElement wTextLinkEasyAuto;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/used/']/div")
	private WebElement wTextLinkAutoUsed;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/']/div")
	private WebElement wTextLinkRealEstate;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/apartments-sale/']/div")
	private WebElement wTextLinkRealEstateApartaments;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/apartments-sale/secondary/']/div")
	private WebElement wTextLinkRealEstateApartamentsSecondary;
	
	@SuppressWarnings("unused")
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/otdam-darom/']/div")
	private WebElement wTextLinkTakeFree;
	
	//@FindBy(xpath="//a[@id='load_user_ads_counter']/span[2]")
	@FindBy(xpath="//li[@class='wrap_lk']//span[@class='dotted']")
	private WebElement wLinkPrivateOffice;
	
	@SuppressWarnings("unused")
	@FindBy(xpath="//div[@id='block_links_lk']/ul/li/a")
	private WebElement wLinkMyAdverts; 
	
	@FindBy(id="logout")
	private WebElement wLinkLogout;
	
	@FindBy(xpath = "//div[@class='b-id']")
	private WebElement wLinkAdvert;
	
	
	@FindBy(xpath = "//span[@id='user_ads_counter']")
	private WebElement wTextMyAdvert;
	
	//div class="b-adListTable"
//////////////////////////////////////////////////////////////////////////////////////////////	

	
	private HM<String, Integer> clsStatusAndCategory;
	private HM<String, String> clsStatusAndCategoryString;
	private String sMas3[] = {"Мои объявления",
			"Все статусы", "Активные", "Снятые с размещения",
			"Все листинг","Неактивные листинг","Активные листинг",
			"Все категории",
			"Авто и мото","Легковые автомобили", "Автомобили с пробегом",
			"Недвижимость", "Квартиры. Продажа", "Вторичный рынок"};
	private Integer iMas3[] = new Integer[14];
	private String sMasCounters[] = new String[14];
	
	public Page_IrrPrivateOffice(WebDriver driver){super(driver); driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// id первого объявления в списке
	public String GetIdAdvert() throws ExceptFailTest
	{
		Sleep(ParseStringToInt(Proper.GetProperty("timeReloadPage"),"Не удалось перевести значение времени перезагрузки страницы timeReloadPage указаного в конфиге в число"));
		driver.get(driver.getCurrentUrl());
		CheckElementPresent(1, "//div[@class='b-id']");
		String s[] = wLinkAdvert.getText().split("\n");
		return s[0].substring(18);
	}
	
	public void ReloadPage(boolean bFlag) throws ExceptFailTest
	{
		if(bFlag)
		{
			Sleep(ParseStringToInt(Proper.GetProperty("timeReloadPage"),"Не удалось перевести значение времени перезагрузки страницы timeReloadPage указаного в конфиге в число"));
		}
		driver.get(driver.getCurrentUrl());
	}
	
	// Значение всех счетчиков
	public void GetStatusAndCategory() throws ExceptFailTest
	{
		//Sleep(ParseStringToInt(Proper.GetProperty("timeReloadPage"),"Не удалось перевести значение времени перезагрузки страницы timeReloadPage указаного в конфиге в число"));
		//driver.get(driver.getCurrentUrl());
		
		print("ПОЛУЧАЕМ ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЁТЧИКОВ В ЛК");
		wLog.WriteString(3, "ПОЛУЧАЕМ ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЁТЧИКОВ В ЛК");
		Sleep(1500);
		print("Нажимаем на ссылку Личный кабинет");
		wLinkPrivateOffice.click();
		print("Ссылка Личный кабинет нажата " + wTextMyAdvert.getText());
		Sleep(1700);
		CheckElementPresent(1, "//div[@id='block_links_lk']/ul/li/a/span"); // счетчик количества объявлений
		//String s[] = wLinkMyAdverts.getText().split("\n");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		CheckElementPresent(1, "//div[@id='block_links_lk']/ul/li/a"); // мои объявления
		CheckElementPresent(1, "//div[@id='minWidth']//li[@class='all'][1]/div[2]"); // все сатусы
		CheckElementPresent(1, "//div[@id='minWidth']//li[2]/a/div"); // активные
		CheckElementPresent(1, "//div[@id='minWidth']//li[3]/a/div"); // неактивные
		CheckElementPresent(1, "//div[@class='b-blockInf'][2]//li[@class='all']/div[2]"); // все категории
		
		//iMas3[0]=ParseStringToInt(s[0], "Не удалось перевести значение количества объявлений в число");
		iMas3[0]=ParseStringToInt(wTextMyAdvert.getText(), "Не удалось перевести значение количества объявлений в ссылке Мои объявления");
		iMas3[1]=ParseStringToInt(wTextAllStatus.getText(), "Не удалось перевести значение количества объявлений в число");
		iMas3[2]=ParseStringToInt(wLinkActiveStatus.getText(),"Не удалось перевести значение количества активных объявлений в число");
		iMas3[3]=ParseStringToInt(wLinkNotActiveStatus.getText(),"Не удалось перевести значение количества неактивных объявлений в число");		
		long AllAdvertListing = (Long) js.executeScript("return document.getElementsByClassName(\"rowsButton\").length;"); // получили количество отображаемых объявлений все статусы(активно неактивно)
		long NotActoveAdvertListing = (Long)js.executeScript("return document.getElementsByClassName(\"wrButton\").length");  // неактивные отображаемые , есть кнопка разместить
		iMas3[4] = (int)AllAdvertListing;
		iMas3[5] = (int)NotActoveAdvertListing;
		iMas3[6] = (int)AllAdvertListing - (int)NotActoveAdvertListing;
		iMas3[7] = ParseStringToInt(wTextAllStatus.getText(), "Не удалось перевести значение количества объявлений в число");
		
		//sMasCounters[0] = s[0];
		sMasCounters[0] = wTextMyAdvert.getText();
		sMasCounters[1] = wTextAllStatus.getText();
		sMasCounters[2] = wLinkActiveStatus.getText();
		sMasCounters[3] = wLinkNotActiveStatus.getText();
		sMasCounters[4] = String.valueOf(AllAdvertListing);
		sMasCounters[5] = String.valueOf(NotActoveAdvertListing);
		sMasCounters[6] = String.valueOf((AllAdvertListing-NotActoveAdvertListing));
		sMasCounters[7]	= wTextAllStatus.getText();
		
		// Для рубрики Авто и мото
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div", sMas3[8]))
		{
			iMas3[8] = ParseStringToInt(wTextLinkAutoAndMoto.getText(),"Не удалось перевести значение счетчика \"Авто и мото\" в число в блоке \"Категори\"");
			sMasCounters[8] = wTextLinkAutoAndMoto.getText();
		}
		else
		{
			iMas3[8] = -99999;
			sMasCounters[8] = "No";
		}
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/']/div", sMas3[9]))
		{
			iMas3[9] = ParseStringToInt(wTextLinkEasyAuto.getText(),"Не удалось перевести значение счетчика \"Легковые автомобили\" в число в блоке \"Категори\"");
			sMasCounters[9] = wTextLinkEasyAuto.getText();
		}
		else
		{
			iMas3[9] = -99999;
			sMasCounters[9] = "No";
		}
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/used/']/div", sMas3[10]))
		{
			iMas3[10] = ParseStringToInt(wTextLinkAutoUsed.getText(),"Не удалось перевести значение счетчика \"Автомобили с пробегом\" в число в блоке \"Категори\"");
			sMasCounters[10] = wTextLinkAutoUsed.getText();
		}
		else
		{
			iMas3[10] = -99999;
			sMasCounters[10] = "No";
		}
		// Для рубрики Недвижимость
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/']/div", sMas3[11]))
		{
			iMas3[11] = ParseStringToInt(wTextLinkRealEstate.getText(),"Не удалось перевести значение счетчика \"Недвижимость\" в число в блоке \"Категори\"");
			sMasCounters[11] = wTextLinkRealEstate.getText();
		}
		else
		{
			iMas3[11] = -99999;
			sMasCounters[11] = "No";
		}
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/apartments-sale/']/div", sMas3[12]))
		{
			iMas3[12] = ParseStringToInt(wTextLinkRealEstateApartaments.getText(),"Не удалось перевести значение счетчика \"Квартиры. Продажа\" в число в блоке \"Категори\"");
			sMasCounters[12] = wTextLinkRealEstateApartaments.getText();
		}
		else
		{
			iMas3[12] = -99999;
			sMasCounters[12] = "No";
		}
		if(CheckLink("//div[@class='b-blockInf'][2]//a[@href='/myadverts/real-estate/apartments-sale/secondary/']/div", sMas3[13]))
		{
			iMas3[13] = ParseStringToInt(wTextLinkRealEstateApartamentsSecondary.getText(),"Не удалось перевести значение счетчика \"Вторичный рынок\" в число в блоке \"Категори\"");
			sMasCounters[13] = wTextLinkRealEstateApartamentsSecondary.getText();
		}
		else
		{
			iMas3[13] = -99999;
			sMasCounters[13] = "No";
		}
		
		clsStatusAndCategoryString = new HM<String,String>(sMas3, sMasCounters);
		print("");
		print("ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЕТЧИКОВ:");
		wLog.WriteString(3, "ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЕТЧИКОВ:");
		clsStatusAndCategoryString.PrintKeyAndValue(wLog);
		print("");
		
		
		/*clsStatusAndCategory = new HM<String,Integer>(sMas3, iMas3);
		
		print("");
		print("ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЕТЧИКОВ:");
		wLog.WriteString(1,"");
		wLog.WriteString(1, "ТЕКУЩИЕ ЗНАЧЕНИЯ СЧЕТЧИКОВ:");
		clsStatusAndCategory.PrintKeyAndValue(wLog);
		print("");
		wLog.WriteString(1,"");
		*/
		
		
	}
	
	//проверка есть ли ссылки для авто или недвижимости
	private boolean CheckLink(final String sLocator, String sName)
	{
		WebElement wElement = null;
		WebDriverWait wWaitDriver = new WebDriverWait(driver, 2);
		try
		{
			wElement = wWaitDriver.until(new ExpectedCondition<WebElement>()
					{
				public WebElement apply(WebDriver wd)
				{
					return  wd.findElement(By.xpath(sLocator));
				}
					}								
										);
		}
		catch(TimeoutException exc){System.out.println("Ссылка "+sName+" не найдена");}
		if(wElement == null)
			return false;
		else return true;
	}
	// проверка всех счетчиков для int
	public void CheckAllCountersAfterChangeData(
			int nMyAdvert,
			int nAllStatus, int nActiveS, int nNotActiveS,
			int nAllList, int nNotActiveL, int nActiveL,
			int nAllCategory,
			int nMainAuto, int nEasyCars, int nUsedCars,
			int nMainRealt, int nRealtSell, int nRealtSecond,
			String sOperation
												) throws ExceptFailTest
	{
		@SuppressWarnings("unused")
		HM<String, Integer> clsOldStatusAndCategory = clsStatusAndCategory;
		boolean bFlag1, bFlag2, bFlag3, bFlag4, bFlag5, bFlag6, bFlag7, bFlag8, bFlag9, bFlag10, bFlag11, bFlag12, bFlag13, bFlag14;
		
		print("Проверяем значения счетчиков после операции: "+ sOperation);
		wLog.WriteString(1, "Проверяем значения счетчиков после операции: "+sOperation);
		
		// Мои объявления
		bFlag1 = CheckCurrentCounter("Мои объявления", nMyAdvert);
		
		// Все статусы
		bFlag2  = CheckCurrentCounter("Все статусы", nAllStatus);
		// Активные
		bFlag3  = CheckCurrentCounter("Активные", nActiveS);
		// Снятые с размещения
		bFlag4  = CheckCurrentCounter("Снятые с размещения", nNotActiveS);
		
		// Все листинг
		bFlag5  = CheckCurrentCounter("Все листинг", nAllList);
		// Неактивные листинг
		bFlag6  = CheckCurrentCounter("Неактивные листинг", nNotActiveL);
		// Активные листинг
		bFlag7  = CheckCurrentCounter("Активные листинг", nActiveL);
		
		// Все категории
		bFlag8  = CheckCurrentCounter("Все категории", nAllCategory);
		
		// Авто и мото
		bFlag9  = CheckCurrentCounter("Авто и мото", nMainAuto);
		// Легковые автомобили
		bFlag10  = CheckCurrentCounter("Легковые автомобили", nEasyCars);
		// Автомобили с пробегом
		bFlag11  = CheckCurrentCounter("Автомобили с пробегом", nUsedCars);
		
		// Недвижимость
		bFlag12  = CheckCurrentCounter("Недвижимость", nMainRealt);
		// Квартиры. Продажа
		bFlag13  = CheckCurrentCounter("Квартиры. Продажа", nRealtSell);
		// Вторичный рынок
		bFlag14  = CheckCurrentCounter("Вторичный рынок", nRealtSecond);
		
		if(bFlag1 || bFlag2 || bFlag3 || bFlag4 || bFlag5 || bFlag6 || bFlag7 || bFlag8 || bFlag9 || bFlag10 || bFlag11 || bFlag12 || bFlag13 || bFlag14)
		{
			print("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
			wLog.WriteString(2,"Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
			throw new ExceptFailTest("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
		}
		print("Значения счетчиков для операции "+sOperation+" корректны");
		wLog.WriteString(1,"Значения счетчиков для операции "+sOperation+" корректны");
	}
	
	// проверка всех счетчиков для String
	public boolean CheckAllCountersAfterChangeData(
			String sMyAdvert,
			String sAllStatus, String sActiveS, String sNotActiveS,
			String sAllList, String sNotActiveL, String sActiveL,
			String sAllCategory,
			String sMainAuto, String sEasyCars, String sUsedCars,
			String sMainRealt, String sRealtSell, String sRealtSecond,
			String sOperation
												) throws ExceptFailTest
	{
		@SuppressWarnings("unused")
		HM<String, String> clsOldStatusAndCategory = clsStatusAndCategoryString;
		boolean bFlag1, bFlag2, bFlag3, bFlag4, bFlag5, bFlag6, bFlag7, bFlag8, bFlag9, bFlag10, bFlag11, bFlag12, bFlag13, bFlag14;
		
		print("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ ПОСЛЕ ОПЕРАЦИИ: "+ sOperation);
		wLog.WriteString(3, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ ПОСЛЕ ОПЕРАЦИИ: "+sOperation);
		
		// Мои объявления
		bFlag1 = CheckCurrentCounter("Мои объявления", sMyAdvert);
		
		// Все статусы
		bFlag2  = CheckCurrentCounter("Все статусы", sAllStatus);
		// Активные
		bFlag3  = CheckCurrentCounter("Активные", sActiveS);
		// Снятые с размещения
		bFlag4  = CheckCurrentCounter("Снятые с размещения", sNotActiveS);
		
		// Все листинг
		bFlag5  = CheckCurrentCounter("Все листинг", sAllList);
		// Неактивные листинг
		bFlag6  = CheckCurrentCounter("Неактивные листинг", sNotActiveL);
		// Активные листинг
		bFlag7  = CheckCurrentCounter("Активные листинг", sActiveL);
		
		// Все категории
		bFlag8  = CheckCurrentCounter("Все категории", sAllCategory);
		
		// Авто и мото
		bFlag9  = CheckCurrentCounterForAutoAndRealtString("Авто и мото", sMainAuto);
		// Легковые автомобили
		bFlag10  = CheckCurrentCounterForAutoAndRealtString("Легковые автомобили", sEasyCars);
		// Автомобили с пробегом
		bFlag11  = CheckCurrentCounterForAutoAndRealtString("Автомобили с пробегом", sUsedCars);
		
		// Недвижимость
		bFlag12  = CheckCurrentCounterForAutoAndRealtString("Недвижимость", sMainRealt);
		// Квартиры. Продажа
		bFlag13  = CheckCurrentCounterForAutoAndRealtString("Квартиры. Продажа", sRealtSell);
		// Вторичный рынок
		bFlag14  = CheckCurrentCounterForAutoAndRealtString("Вторичный рынок", sRealtSecond);
		
		if(bFlag1 || bFlag2 || bFlag3 || bFlag4 || bFlag5 || bFlag6 || bFlag7 || bFlag8 || bFlag9 || bFlag10 || bFlag11 || bFlag12 || bFlag13 || bFlag14)
		{
			print("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
			wLog.WriteString(2,"Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
			//throw new ExceptFailTest("Значение(я) счетчика(ов) выше не совпало с правильным(и) значение(ями) счетчика(ов)");
			return false;
		}
		print("ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ ОПЕРАЦИИ " + sOperation + "\r\nКОРРЕКТНЫ");
		wLog.WriteString(3,"ЗНАЧЕНИЯ СЧЕТЧИКОВ ДЛЯ ОПЕРАЦИИ " + sOperation + "\r\nКОРРЕКTНЫ");
		return true;
	}
	
	// проверка конкретного счетчика для String
	private boolean CheckCurrentCounter(String sNameCounter, String sCounter) throws ExceptFailTest
	{
		if(!clsStatusAndCategoryString.GetValue(sNameCounter).equals(sCounter))
		{
			print("Значение счетчика \"" + sNameCounter + "\" = " + clsStatusAndCategoryString.GetValue(sNameCounter) + " не равно правильному значению счетчика = " + sCounter);
			wLog.WriteString(2, "Значение счетчика \"" + sNameCounter + "\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter) + " не равно правильному значению счетчика = " +  sCounter);
			return true;
		}
		else
		{
			print("Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" равно правильному значению счетчика = " + sCounter);
			wLog.WriteString(1, "Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" равно правильному значению счетчика = " +  sCounter);
			return false;
		}
	}
	
	// проверка конкретного счетчика для Авто и Недвижимости 
	private boolean CheckCurrentCounterForAutoAndRealtString(String sNameCounter, String sCounter) throws ExceptFailTest
	{
		if(sCounter.equalsIgnoreCase("нет"))
		{
			if(clsStatusAndCategoryString.GetValue(sNameCounter).equalsIgnoreCase(sCounter))
			{
				print("Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Корректно.");
				wLog.WriteString(1, "Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Корректно.");
				return false;
			}
			else
			{
				print("Ссылка(и значение счетчика) \""+ sNameCounter +"\" присутствует, значение счетчика для нее = "+clsStatusAndCategoryString.GetValue(sNameCounter)+". Но ее не должно быть. Некорректно.");
				wLog.WriteString(2, "Ссылка(и значение счетчика) \""+ sNameCounter +"\" присутствует, значение счетчика для нее = "+clsStatusAndCategoryString.GetValue(sNameCounter)+". Но ее не должно быть. Некорректно.");
				return true;
			}
				
		}
		
		if(clsStatusAndCategoryString.GetValue(sNameCounter).equalsIgnoreCase("нет"))
		{
			if(clsStatusAndCategoryString.GetValue(sNameCounter).equalsIgnoreCase(sCounter))
			{
				print("Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Корректно.");
				wLog.WriteString(1, "Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Корректно.");
				return false;
			}
			else
			{
				print("Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Но она должна быть и ее зачение должно быть ="+ sCounter +". Некорректно.");
				wLog.WriteString(2, "Ссылка(и значение счетчика) \""+ sNameCounter +"\" отсутствует. Но она должна быть и ее зачение должно быть ="+ sCounter +". Некорректно.");
				return true;
			}
		}
		
		if(!clsStatusAndCategoryString.GetValue(sNameCounter).equals(sCounter))
		{
			print("Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" не равно правильному значению счетчика = " + sCounter);
			wLog.WriteString(2, "Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" не равно правильному значению счетчика = " +  sCounter);
			return true;
		}
		else
		{
			print("Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" равно правильному значению счетчика = " + sCounter);
			wLog.WriteString(1, "Значение счетчика \""+ sNameCounter +"\" = "+ clsStatusAndCategoryString.GetValue(sNameCounter)+" равно правильному значению счетчика = " +  sCounter);
			return false;
		}
	}
	
	
	// проверка конкретного счетчика для int
	private boolean CheckCurrentCounter(String sNameCounter, int nCounter) throws ExceptFailTest
	{
		if(clsStatusAndCategory.GetValue(sNameCounter) != nCounter)
		{
			print("Значение счетчика \""+sNameCounter +"\" = "+ clsStatusAndCategory.GetValue(sNameCounter)+" не равно правильному значению счетчика = " + nCounter);
			wLog.WriteString(2, "Значение счетчика \""+sNameCounter +"\" = "+ clsStatusAndCategory.GetValue(sNameCounter)+" не равно правильному значению счетчика = " +  nCounter);
			return true;
		}
		else
		{
			print("Значение счетчика \""+sNameCounter +"\" = "+ clsStatusAndCategory.GetValue(sNameCounter)+" равно правильному значению счетчика = " + nCounter);
			wLog.WriteString(1, "Значение счетчика \""+sNameCounter +"\" = "+ clsStatusAndCategory.GetValue(sNameCounter)+" равно правильному значению счетчика = " +  nCounter);
			return false;
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void OpenPage(String sUrl){};
	
	// Удаление всех объявлений
	public void DeleteAllAdvert() throws ExceptFailTest
	{
		wLog.WriteString(1, "УДАЛЯЕМ ВСЕ ОБЪЯВЛЕНИЯ");
		System.out.println("УДАЛЯЕМ ВСЕ ОБЪЯВЛЕНИЯ");
		CheckElementPresent(2, "checkAll");
		wCheckBoxCheckAll.click();
		CheckElementPresent(2, "groupActionDeleteSelected");
		wLinkDeleteSelected.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	// Деактивация объявлений всех
	public void DeactivateAllAdvert() throws ExceptFailTest
	{
		wLog.WriteString(1, "ДЕАКТИВИРУЕМ ВСЕ ОБЪЯВЛЕНИЯ");
		System.out.println("ДЕАКТИВИРУЕМ ВСЕ ОБЪЯВЛЕНИЯ");
		CheckElementPresent(2, "checkAll");
		wCheckBoxCheckAll.click();
		CheckElementPresent(2,"groupActionDeactivateSelected");
		wLinkDeactivateSelected.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	// Логаут
	public void LogOutFromIrr() throws ExceptFailTest
		{
			wLog.WriteString(1, "ВЫЛОГИНИВАЕМСЯ");
			System.out.println("ВЫЛОГИНИВАЕМСЯ");
			CheckElementPresent(2, "logout");
			wLinkLogout.click();
		}
	
	
	private int ParseStringToInt(String sCount, String sMessage) throws ExceptFailTest
	{
		try
		{
			int iTemp = Integer.parseInt(sCount);
			return iTemp;
		}
		catch(NumberFormatException exc)
		{
			wLog.WriteString(1, sMessage);
			throw new ExceptFailTest(sMessage);
		}
	}

}
