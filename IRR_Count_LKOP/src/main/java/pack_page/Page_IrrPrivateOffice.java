package pack_page;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	@FindBy(xpath="//div[@class='b-blockInf'][2]//li[@class='all']/div[2]")
	private WebElement wTextAllCategory;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div")
	private WebElement wTextLinkAutoAndMoto;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/']/div")
	private WebElement wTextLinkEasyAuto;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/used/']/div")
	private WebElement wTextLinkAutoUsed;
	
	@FindBy(xpath="//div[@class='b-blockInf'][2]//a[@href='/myadverts/otdam-darom/']/div")
	private WebElement wTextLinkTakeFree;
	
	@FindBy(id="logout")
	private WebElement wLinkLogout;
	
	//div class="b-adListTable"
//////////////////////////////////////////////////////////////////////////////////////////////	
	private HM<String, Integer> clStatusAdvert;  // для блока Статус
	private String sMas[] = {"Все статусы", "Активные", "Снятые с размещения"};
	private Integer iMas[] = new Integer[3];
	
	private HM<String, Integer> clCategoryAdvert; // Для блока Категории
	private String sMas2[] = {"Все категории","Авто и мото","Отдам даром"};
	private Integer iMas2[] = new Integer[3];
	
	public Page_IrrPrivateOffice(WebDriver driver){super(driver);}

	public void GetStatusForLastLogin(HM<String, Integer> clInStatusAdvert, HM<String, Integer> clInStatusAdvertCategory) throws ExceptFailTest
	{
		clStatusAdvert = clInStatusAdvert;
		clCategoryAdvert = clInStatusAdvertCategory;
		wLog.WriteString(1, "ЗНАЧЕНИЕ СТАТУСА ПЕРЕД ДОБАВЛЕНИЕМ ОБЪЯВЛЕНИЯ");
		System.out.println("ЗНАЧЕНИЕ СТАТУСА ПЕРЕД ДОБАВЛЕНИЕМ ОБЪЯВЛЕНИЯ");
		clStatusAdvert.PrintKeyAndValue(wLog);
		wLog.WriteString(1, "ЗНАЧЕНИЯ КАТЕГОРИЙ ПЕРЕД ДОБАВЛЕНИЕМ ОБЪЯВЛЕНИЯ");
		System.out.println("ЗНАЧЕНИЯ КАТЕГОРИЙ ПЕРЕД ДОБАВЛЕНИЕМ ОБЪЯВЛЕНИЯ");
		clCategoryAdvert.PrintKeyAndValue(wLog);
	}
	
	public HM<String, Integer> SendStatus()
	{
		return clStatusAdvert;
	}
	
	public HM<String, Integer> SendCategory()
	{
		return clCategoryAdvert;
	}
	
	// Для категории проверка что  значение счетчика все категории соответствует значениям счетчиков все статусы и значению сумме счетчиков категорий
	public void CheckCurrentCategory() throws ExceptFailTest
	{
		// Проверяем что значение счетчика Все статусы = значению Все категории
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//li[@class='all']/div[2]");
		wLog.WriteString(1, "ПРОВЕРЯЕМ ЧТО ЗНАЧЕНИЕ СЧЕТЧИКА \"ВСЕ СТАТУСЫ\" РАВНО ЗНАЧЕНИЮ СЧЕТЧИКА \"ВСЕ КАТЕГОРИИ\"");
		System.out.println("ПРОВЕРЯЕМ ЧТО ЗНАЧЕНИЕ СЧЕТЧИКА \"ВСЕ СТАТУСЫ\" РАВНО ЗНАЧЕНИЮ СЧЕТЧИКА \"ВСЕ КАТЕГОРИИ\"");
		int iAllCategory = ParseStringToInt(wTextAllCategory.getText(),"Не удалось перевести значение счетчика \"Все категори\" в число в блоке \"Категори\"");
		int iAllStatus = ParseStringToInt(wTextAllStatus.getText(), "Не удалось перевести значение количества объявлений в число");
		wLog.WriteString(1, "Значение счетчика \"Все категории\" в блоке \"Категории\" равно: "+iAllCategory);
		System.out.println("Значение счетчика \"Все категории\" в блоке \"Категории\" равно: "+iAllCategory);
		wLog.WriteString(1, "Значение счетчика \"Все статусы\" в блоке \"Cтатусы\" равно: "+iAllStatus);
		System.out.println("Значение счетчика \"Все статусы\" в блоке \"Cтатусы\" равно: "+iAllStatus);
		if(iAllCategory != iAllStatus)
		{
			wLog.WriteString(2, "Значение счетчика \"Все статусы\" в блоке \"Статус\" не равно значению счетчика \"Все категории\" в блоке \"Категории\"");
			throw new ExceptFailTest("Значение счетчика \"Все статусы\" в блоке \"Статус\" не равно значению счетчика \"Все категории\" в блоке \"Категории\""); 
		}
		else 
		{
			wLog.WriteString(1, "Значение счетчика \"Все статусы\" в блоке \"Статус\" равно значению счетчика \"Все категории\" в блоке \"Категории\"");
			System.out.println("Значение счетчика \"Все статусы\" в блоке \"Статус\" равно значению счетчика \"Все категории\" в блоке \"Категории\"");
		}
		// Поверяем что если объявления есть то значение счетчика все категории равно сумме значений счетчиков  категорий
		if(iAllCategory != 0)
		{
			CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div");
			CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/otdam-darom/']/div");
			int iAuto = ParseStringToInt(wTextLinkAutoAndMoto.getText(),"Не удалось перевести значение счетчика \"Авто и мото\" в число в блоке \"Категори\"");
			int iTakeFree  = ParseStringToInt(wTextLinkTakeFree.getText(),"Не удалось перевести значение счетчика \"Отдам даром\" в число в блоке \"Категори\"");
			wLog.WriteString(1, "ПРОВЕРЯЕМ ЧТО СУММА ЗНАЧЕНИЙ СЧЕТЧИКОВ ГЛАВНЫХ КАТЕГОРИЙ " +
					"РАВНА ЗНАЧЕНИЮ СЧЕТЧИКА \"ВСЕ КАТЕГОРИИ\" В БЛОКЕ \"КАТЕГОРИИ\"");
			System.out.println("ПРОВЕРЯЕМ ЧТО СУММА ЗНАЧЕНИЙ СЧЕТЧИКОВ ГЛАВНЫХ КАТЕГОРИЙ " +
					"РАВНА ЗНАЧЕНИЮ СЧЕТЧИКА \"ВСЕ КАТЕГОРИИ\" В БЛОКЕ \"КАТЕГОРИИ\"");
			wLog.WriteString(1, "Значение счетчика \"Все категории\" в блоке \"Категории\" равно: "+iAllCategory);
			System.out.println("Значение счетчика \"Все категории\" в блоке \"Категории\" равно: "+iAllCategory);
			wLog.WriteString(1, "Сумма значений счетчиков \"Авто и мото\" и \"Отдам даром\" равно: "+(iAuto+iTakeFree));
			System.out.println("Сумма значений счетчиков \"Авто и мото\" и \"Отдам даром\" равно: "+(iAuto+iTakeFree));
			if(iAllCategory == (iAuto+iTakeFree))
			{
				wLog.WriteString(1, "В блоке \"Категории\" сумма значений счетчиков главных категорий равно значению счетчика \"Все категории\"");
				System.out.println("В блоке \"Категории\" сумма значений счетчиков главных категорий равно значению счетчика \"Все категории\"");
				return;
			}
			else
			{
				wLog.WriteString(1, "Cумма значений счетчиков главных категорий не равно значению счетчика \"Все категории\" в блоке \"Категории\"");
				throw new ExceptFailTest("Cумма значений счетчиков главных категорий не равно значению счетчика \"Все категории\" в блоке \"Категории\"");
			}
		}
		
		//  Проверяем что если объявлений нет счетчик Все категории равен 0 , то и нет ссылок на категории
		if(iAllCategory == 0)
		{
			wLog.WriteString(1, "ПРОВЕРЯЕМ ЧТО БЛОК \"КАТЕГОРИИ\" НЕ СОДЕРЖИТ ССЫЛОК НА КАТЕГОРИИ И ПОДКАТЕГОРИИ");
			System.out.println("ПРОВЕРЯЕМ ЧТО БЛОК \"КАТЕГОРИИ\" НЕ СОДЕРЖИТ ССЫЛОК НА КАТЕГОРИИ И ПОДКАТЕГОРИИ");
			wLog.WriteString(1, "Значение счетчика \"Все категории\" в блоке \"Категории\" равно 0");
			System.out.println("Значение счетчика \"Все категории\" в блоке \"Категории\" равно 0");
			if(GetCountAllChildrenCategoryFromListCategory() == 0)
			{
				wLog.WriteString(1, "В блоке \"Категории\" отсутсвуют записи о категориях.");
				System.out.println("В блоке \"Категории\" отсутсвуют записи о категориях.");
				Integer iTemp[] = {0,0,0}; // Если все объявления удалены то надо обнулить хранилище категории
				clCategoryAdvert = new HM<String,Integer>(sMas2, iTemp);
				return;
			}
			else 
			{
				wLog.WriteString(2, "Значения счетчика \"Все категории\" в блоке \"Категории\" равно 0, однако в блоке присутствуют записи о категориях");
				throw new ExceptFailTest("Значения счетчика \"Все категории\" в блоке \"Категории\" равно 0, однако в блоке присутствуют записи о категориях");
			}
		} 
	}
	
	public void GetCurrentCategory() throws ExceptFailTest
	{
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//li[@class='all']/div[2]");
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div");
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/otdam-darom/']/div");
		iMas2[0] = ParseStringToInt(wTextAllCategory.getText(),"Не удалось перевести значение счетчика \"Все категори\" в число в блоке \"Категори\"");
		iMas2[1] = ParseStringToInt(wTextLinkAutoAndMoto.getText(),"Не удалось перевести значение счетчика \"Авто и мото\" в число в блоке \"Категори\"");
		iMas2[2] = ParseStringToInt(wTextLinkTakeFree.getText(),"Не удалось перевести значение счетчика \"Отдам даром\" в число в блоке \"Категори\"");
		
		clCategoryAdvert = new HM<String,Integer>(sMas2, iMas2);
		wLog.WriteString(1, "ЗНАЧЕНИЯ ТЕКУЩИХ КАТЕГОРИЙ:");
		System.out.println("ЗНАЧЕНИЯ ТЕКУЩИХ КАТЕГОРИЙ:");
		clCategoryAdvert.PrintKeyAndValue(wLog);
	}
	
	public void CheckOldAndNewCategory(int nOperation) throws ExceptFailTest
	{
		HM<String, Integer> clOldCategoryAdvert = clCategoryAdvert;
		GetCurrentCategory();
		switch (nOperation)
		{
			case 1:// деактивация
				wLog.WriteString(1, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"КАТЕГОРИИ\" ПОСЛЕ ДЕАКТИВАЦИИ");
				System.out.println("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"КАТЕГОРИИ\" ПОСЛЕ ДЕАКТИВАЦИИ");
				if(clOldCategoryAdvert.GetValue("Все категории") != clCategoryAdvert.GetValue("Все категории"))
				{
					wLog.WriteString(2, "Значение счетчика \"Все категории\" после деактивации объявлений не равно старому значению счетчика \"Все категории\" до деактивации");
					throw new ExceptFailTest("Значение счетчика \"Все категории\" после деактивации объявлений не равно старому значению счетчика \"Все категории\" до деактивации");
				}
				if(clOldCategoryAdvert.GetValue("Авто и мото") != clCategoryAdvert.GetValue("Авто и мото"))
				{
					wLog.WriteString(2, "Значение счетчика \"Авто и мото\" после деактивации объявлений не равно старому значению счетчика \"Авто и мото\" до деактивации");
					throw new ExceptFailTest("Значение счетчика \"Авто и мото\" после деактивации объявлений не равно старому значению счетчика \"Авто и мото\" до деактивации");
				}
				if(clOldCategoryAdvert.GetValue("Отдам даром") != clCategoryAdvert.GetValue("Отдам даром"))
				{
					wLog.WriteString(2, "Значение счетчика \"Отдам даром\" после деактивации объявлений не равно старому значению счетчика \"Отдам даром\" до деактивации");
					throw new ExceptFailTest("Значение счетчика \"Отдам даром\" после деактивации объявлений не равно старому значению счетчика \"Отдам даром\" до деактивации");
				}
				wLog.WriteString(1, "Значение счетчиков в блоке \"Все категории\" после деактивации корреткны, остались прежними");
				System.out.println("Значение счетчиков в блоке \"Все категории\" после деактивации корреткны, остались прежними");
				wLog.WriteString(1, "ПРОВЕРЯЕМ СООТВЕТСТВИЕ ЗНАЧЕНИЙ СЧЕТЧИКОВ РУБРИКИ К ЕЕ ПОДРУБРИКАМ. РУБРИКА АВТО.");
				System.out.println("ПРОВЕРЯЕМ СООТВЕТСТВИЕ ЗНАЧЕНИЙ СЧЕТЧИКОВ РУБРИКИ К ЕЕ ПОДРУБРИКАМ. РУБРИКА АВТО.");
				CheckCountAuto();
				break;
			case 2: // добавление
				wLog.WriteString(1, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"КАТЕГОРИИ\" ПОСЛЕ ДОБАВЛЕНИЯ ОБЪЯВЛЕНИЙ");
				System.out.println("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"КАТЕГОРИИ\" ПОСЛЕ ДОБАВЛЕНИЯ ОБЪЯВЛЕНИЙ");
				if((clOldCategoryAdvert.GetValue("Все категории")+2) != clCategoryAdvert.GetValue("Все категории"))
				{
					wLog.WriteString(2, "Значения счетчика \"Все категории\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
					throw new ExceptFailTest("Значения счетчика \"Все категории\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
				}
				if((clOldCategoryAdvert.GetValue("Авто и мото")+1) != clCategoryAdvert.GetValue("Авто и мото"))
				{
					wLog.WriteString(2, "Значения счетчика \"Авто и мото\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
					throw new ExceptFailTest("Значения счетчика \"Авто и мото\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
				}
				if((clOldCategoryAdvert.GetValue("Отдам даром")+1) != clCategoryAdvert.GetValue("Отдам даром"))
				{
					wLog.WriteString(2, "Значения счетчика \"Отдам даром\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
					throw new ExceptFailTest("Значения счетчика \"Отдам даром\" в блоке \"Категории\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
				}
				wLog.WriteString(1, "Значение счетчиков корректны, объявления добавлены");
				System.out.println("Значение счетчиков корректны, объявления добавлены");
				wLog.WriteString(1, "ПРОВЕРЯЕМ СООТВЕТСТВИЕ ЗНАЧЕНИЙ СЧЕТЧИКОВ РУБРИКИ К ЕЕ ПОДРУБРИКАМ. РУБРИКА АВТО.");
				System.out.println("ПРОВЕРЯЕМ СООТВЕТСТВИЕ ЗНАЧЕНИЙ СЧЕТЧИКОВ РУБРИКИ К ЕЕ ПОДРУБРИКАМ. РУБРИКА АВТО.");
				CheckCountAuto();
				break;
		}
		
	}
	
	
	// Получение значений счетчиков в блоке Статус
	public void GetCurrentStatus() throws ExceptFailTest
	{
		CheckElementPresent(1, "//div[@id='minWidth']//li[@class='all'][1]/div[2]");
		CheckElementPresent(1,  "//div[@id='minWidth']//li[2]/a/div");
		CheckElementPresent(1,  "//div[@id='minWidth']//li[3]/a/div");
		
		iMas[0]=ParseStringToInt(wTextAllStatus.getText(), "Не удалось перевести значение количества объявлений в число");
		iMas[1]=ParseStringToInt(wLinkActiveStatus.getText(),"Не удалось перевести значение количества активных объявлений в число");
		iMas[2]=ParseStringToInt(wLinkNotActiveStatus.getText(),"Не удалось перевести значение количества неактивных объявлений в число");
		
		clStatusAdvert = new HM<String,Integer>(sMas, iMas);
		wLog.WriteString(1, "ЗНАЧЕНИЯ ТЕКУЩЕГО СТАТУСА:");
		System.out.println("ЗНАЧЕНИЯ ТЕКУЩЕГО СТАТУСА:");
		clStatusAdvert.PrintKeyAndValue(wLog);	
	}
	
	// Проверка счетчиков для блока Статус 
	public void CheckOldAndNewStatus(int nOperation) throws ExceptFailTest
	{
		HM<String, Integer> clOldStatus = clStatusAdvert;
		GetCurrentStatus();
		switch (nOperation)
		{
			case 1:// деактивация
				wLog.WriteString(1, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ ДЕАКТИВАЦИИ");
				System.out.println("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ ДЕАКТИВАЦИИ");
				if(clOldStatus.GetValue("Все статусы") != clStatusAdvert.GetValue("Все статусы"))
				{
					wLog.WriteString(2, "Новое значение счетчика \"Все статусы\" в блоке \"Статус\" после деактивации объявлений не равно старому значению");
					throw new ExceptFailTest("Новое значение счетчика \"Все статусы\" в блоке \"Статус\" после деактивации объявлений не равно старому значению");
				}
				if(clStatusAdvert.GetValue("Активные") !=  0)
				{
					wLog.WriteString(2, "Значение счетчика \"Активные\" после деактивации всех объявлений не равно нулю");
					throw new ExceptFailTest("Значение счетчика \"Активные\" после деактивации всех объявлений не равно нулю");
				}
				if((clOldStatus.GetValue("Активные") + clOldStatus.GetValue("Снятые с размещения")) != clStatusAdvert.GetValue("Снятые с размещения"))
				{
					wLog.WriteString(2, "Значение счетчика \"Снятые с размещения\" после деактивации всех объявлений не равно значению счетчика \"Активные\" до активации всех объявлений");
					throw new ExceptFailTest("Значение счетчика \"Снятые с размещения\" после деактивации всех объявлений не равно значению счетчика \"Активные\" до активации всех объявлений");
				}
				wLog.WriteString(1, "Значение счетчиков корректны, все объявления деактивированы");
				System.out.println("Значение счетчиков корректны, все объявления деактивированы");
				break;
			case 2://удаление
				wLog.WriteString(1, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ УДАЛЕНИЯ");
				System.out.println("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ УДАЛЕНИЯ");
				if((clStatusAdvert.GetValue("Все статусы") != 0) || (clStatusAdvert.GetValue("Активные") != 0) || (clStatusAdvert.GetValue("Снятые с размещения") != 0))
				{
					wLog.WriteString(2, "Значения счетчиков в блоке \"Статус\" не обнулились,после удаления всех объявлений");
					throw new ExceptFailTest("Значения счетчиков в блоке \"Статус\" не обнулились,после удаления всех объявлений");
				}
				else
				{
					wLog.WriteString(1, "Значение счетчиков в блоке \"Статус\" корректны, после удаления всех объявлений равны нулю");
					System.out.println("Значение счетчиков в блоке \"Статус\" корректны, после удаления всех объявлений равны нулю");
				}
				break;
			case 3://добавление
				wLog.WriteString(1, "ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ ДОБАВЛЕНИЯ ОБЪЯВЛЕНИЙ");
				System.out.println("ПРОВЕРЯЕМ ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУС\" ПОСЛЕ ДОБАВЛЕНИЯ ОБЪЯВЛЕНИЙ");
				if( (clOldStatus.GetValue("Все статусы")+2) != clStatusAdvert.GetValue("Все статусы") ) 
				{
					wLog.WriteString(2, "Значения счетчиков \"Все статусы\" в блоке \"Статус\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
					throw new ExceptFailTest("Значения счетчиков \"Все статусы\" в блоке \"Статус\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
				}
				if( (clOldStatus.GetValue("Активные")+2) != clStatusAdvert.GetValue("Активные") )
				{
					wLog.WriteString(2, "Значения счетчика \"Активные\" в блоке \"Статус\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
					throw new ExceptFailTest("Значения счетчика \"Активные\" в блоке \"Статус\" после добавления объявлений не увеличилось на значение количества добавленных объявлений");
				}
				if( clOldStatus.GetValue("Снятые с размещения") != clStatusAdvert.GetValue("Снятые с размещения") )
				{
					wLog.WriteString(2, "Значения счетчика  \"Снятые с размещения\" в блоке \"Статус\" после добавления объявлений в статусе активно изменилось");
					throw new ExceptFailTest("Значения счетчика  \"Снятые с размещения\" в блоке \"Статус\" после добавления объявлений в статусе активно изменилось");
				}
				wLog.WriteString(1, "Значение счетчиков корректны, объявления добавлены");
				System.out.println("Значение счетчиков корректны, объявления добавлены");
				break;
		}
	}
	
	// Для блока Статус проверка соответствия счетчиков в блоке Статус кроичеству отображаемых объявлений на в  листинге 
	public void CheckCountAndVisibleAdvert () throws ExceptFailTest // Работает для одной страницы. Проверка, что счетчики объявлений со всеми статусами равны соответсенно количеству отображаемых и снятыз в листинге Л
	{
		
		Sleep(ParseStringToInt(Proper.GetProperty("timeReloadPage"),"Не удалось перевести значение времени перезагрузки страницы timeReloadPage указаного в конфиге в число"));
		driver.get(driver.getCurrentUrl());
		wLog.WriteString(1, "ПРОВЕРЯЕМ, ЧТО ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУСЫ\" СООТВЕТСТВУЮТ" +
				" КОЛИЧЕСТВУ ОТОБРАЖАЕМЫХ ОБЪЯВЛЕНИЙ В СООТВЕТСТВУЮЩИХ СТАТУСАХ");
		System.out.println("ПРОВЕРЯЕМ, ЧТО ЗНАЧЕНИЕ СЧЕТЧИКОВ В БЛОКЕ \"СТАТУСЫ\" СООТВЕТСТВУЮТ" +
				" КОЛИЧЕСТВУ ОТОБРАЖАЕМЫХ ОБЪЯВЛЕНИЙ В СООТВЕТСТВУЮЩИХ СТАТУСАХ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Long lVisibleAllAdvert = (Long)js.executeScript("return document.getElementsByClassName(\"rowsButton\").length;"); // получили количество отображаемых объявлений все статусы(активно неактивно)
		Long lVisibleNonActiveAdvert = (Long)js.executeScript("return document.getElementsByClassName(\"wrButton\").length");  // неактивные отображаемые , есть кнопка разместить
		Long lCountAllStatus = (long) ParseStringToInt(wTextAllStatus.getText(), "Не удалось перевести значение количества объявлений в число"); // получили значение счетчика все статусы
		Long lCountNonActiveAdvert = (long) ParseStringToInt(wLinkNotActiveStatus.getText(), "Не удалось перевести значение количества неактивных объявлений в число"); // получили значение счетчика неактивные
		Long lCountActiveAdvert = (long) ParseStringToInt(wLinkActiveStatus.getText(), "Не удалось перевести значение количества активных объявлений в число");
		
		if(lCountAllStatus != lVisibleAllAdvert)
		{
			wLog.WriteString(2, "Значение счетчика \"Все статусы\" "+lCountAllStatus+" не равно количеству отображаемых объявлений "+lVisibleAllAdvert+".");
			throw new ExceptFailTest("Значение счетчика \"Все статусы\" "+lCountAllStatus+" не равно количеству отображаемых объявлений "+lVisibleAllAdvert+".");
		}
		wLog.WriteString(1, "Значение счетчика \"Все статусы\" "+lCountAllStatus+" равно количеству отображаемых объявлений "+lVisibleAllAdvert+".");
		System.out.println("Значение счетчика \"Все статусы\" "+lCountAllStatus+" равно количеству отображаемых объявлений "+lVisibleAllAdvert+".");
		
		if(lCountActiveAdvert != (lVisibleAllAdvert-lVisibleNonActiveAdvert))
		{
			wLog.WriteString(2, "Значение счетчика \"Активные\" "+lCountActiveAdvert+" не равно количеству отображаемых активных объявлений "+(lVisibleAllAdvert-lVisibleNonActiveAdvert)+".");
			throw new ExceptFailTest("Значение счетчика \"Активные\" "+lCountActiveAdvert+" не равно количеству отображаемых активных объявлений "+(lVisibleAllAdvert-lVisibleNonActiveAdvert)+".");
		}
		wLog.WriteString(1, "Значение счетчика \"Активные\" "+lCountActiveAdvert+" равно количеству отображаемых активных объявлений "+(lVisibleAllAdvert-lVisibleNonActiveAdvert)+".");
		System.out.println("Значение счетчика \"Активные\" "+lCountActiveAdvert+" равно количеству отображаемых активных объявлений "+(lVisibleAllAdvert-lVisibleNonActiveAdvert)+".");

		if(lVisibleNonActiveAdvert != lCountNonActiveAdvert)
		{
			wLog.WriteString(2, "Значение счетчика \"Снятые с размещения\" "+lCountNonActiveAdvert+"не равно количеству отображаемых снятых с размещения объявлений "+lVisibleNonActiveAdvert+".");
			throw new ExceptFailTest("Значение счетчика \"Снятые с размещения\" "+lCountNonActiveAdvert+"не равно количеству отображаемых снятых с размещения объявлений "+lVisibleNonActiveAdvert+".");
		}
		wLog.WriteString(1, "Значение счетчика \"Снятые с размещения\" "+lCountNonActiveAdvert+" равно количеству отображаемых снятых с размещения объявлений "+lVisibleNonActiveAdvert+".");
		System.out.println("Значение счетчика \"Снятые с размещения\" "+lCountNonActiveAdvert+" равно количеству отображаемых снятых с размещения объявлений "+lVisibleNonActiveAdvert+".");
	}
	
	@Override
	public void OpenPage(){}
	
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
	
	// Проверяем значение соответвия счетчика рубрики к подрубрикам в Авто
	private void CheckCountAuto() throws ExceptFailTest  
	{
		wLog.WriteString(1, "ПРОВЕРЯЕМ ЧТО ЗНАЧЕНИЕ СЧЕТЧИКА  РУБРИКИ \"АВТО И МОТО\" РАВНО ЗНАЧЕНИЯМ ЕГО" +
				" ПОДРУБИК \"ЛЕГКОВЫЕ АВТОМОБИЛИ\" И \"АВТОМОБИЛИ С ПРОБЕГОМ\" ");
		System.out.println("ПРОВЕРЯЕМ ЧТО ЗНАЧЕНИЕ СЧЕТЧИКА  РУБРИКИ \"АВТО И МОТО\" РАВНО ЗНАЧЕНИЯМ ЕГО" +
				" ПОДРУБИК \"ЛЕГКОВЫЕ АВТОМОБИЛИ\" И \"АВТОМОБИЛИ С ПРОБЕГОМ\" ");
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/']/div");
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/']/div");
		CheckElementPresent(1,"//div[@class='b-blockInf'][2]//a[@href='/myadverts/cars/passenger/used/']/div");
		int iAuto = ParseStringToInt(wTextLinkAutoAndMoto.getText(),"Не удалось перевести значение счетчика \"Авто и мото\" в число в блоке \"Категори\"");
		int iEasyAuto = ParseStringToInt(wTextLinkEasyAuto.getText(),"Не удалось перевести значение счетчика \"Легковые автомобили\" в число в блоке \"Категори\"");
		int iAutoUsed = ParseStringToInt(wTextLinkAutoUsed.getText(),"Не удалось перевести значение счетчика \"Автомобили с пробегом\" в число в блоке \"Категори\""); 	
		wLog.WriteString(1, "Счетчик \"Авто и мото\" равен: "+ iAuto);
		System.out.println("Счетчик \"Авто и мото\" равен: "+ iAuto);
		wLog.WriteString(1, "Счетчик \"Легковые автомобили\" равен: "+ iEasyAuto);
		System.out.println("Счетчик \"Легковые автомобили\" равен: "+ iEasyAuto);
		wLog.WriteString(1, "Счетчик \"Автомобили с пробегом\" равен: "+ iEasyAuto);
		System.out.println("Счетчик \"Автомобили с пробегом\" равен: "+ iEasyAuto);
		if((iAuto != iEasyAuto) || (iEasyAuto != iAutoUsed) || (iAutoUsed != iAuto))
		{
			wLog.WriteString(2, "Значение счетчика  рубрики \"Авто и мото\" не равно значениям его подрубик \"Легковые автомобили\" и \"Автомобили с пробегом\" ");
			throw new ExceptFailTest("Значение счетчика  рубрики \"Авто и мото\" не равно значениям его подрубик \"Легковые автомобили\" и \"Автомобили с пробегом\" ");
		}
		wLog.WriteString(1, "Значение счетчика в рубрике \"Авто и Мото\" равно значениям его подрубик \"Легковые автомобили\" и \"Автомобили с пробегом\"");
		System.out.println("Значение счетчика в рубрике \"Авто и Мото\" равно значениям его подрубик \"Легковые автомобили\" и \"Автомобили с пробегом\"");
	}
	
	// Для категорий -  количество всех категорий и подкатегорий
	private Long GetCountAllChildrenCategoryFromListCategory() throws ExceptFailTest
	{
		wLog.WriteString(1, "ПОЛУЧАЕМ КОЛИЧЕСТВО ЗАПИСЕЙ(ССЫЛОК) О КАТЕГОРИЯХ И ПОДКАТЕГОРИЯХ В БЛОКЕ \"КАТЕГОРИИ\"");
		System.out.println("ПОЛУЧАЕМ КОЛИЧЕСТВО ЗАПИСЕЙ(ССЫЛОК) О КАТЕГОРИЯХ И ПОДКАТЕГОРИЯХ В БЛОКЕ \"КАТЕГОРИИ\"");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Long lLinkAllAdvertCategory = (Long)js.executeScript(" var j = document.getElementsByClassName(\"b-blockInf\"); return j[1].getElementsByTagName(\"a\").length ");
		wLog.WriteString(1, "Количество записей о категориях и подкатегориях в блоке \"Категории\" равно: "+lLinkAllAdvertCategory);
		System.out.println("Количество записей о категориях и подкатегориях в блоке \"Категории\" равно: "+lLinkAllAdvertCategory);
		return lLinkAllAdvertCategory;
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
