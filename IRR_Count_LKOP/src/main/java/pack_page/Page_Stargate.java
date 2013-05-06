package pack_page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pack_utils.ExceptFailTest;
import pack_utils.Proper;

//конфиг с данными для объявок надо сделать
//логатор

public class Page_Stargate extends Page
{
	@FindBy(xpath="//a[@href='/stargate/?logout=true']")
	private WebElement wLinkLogout;
	// Блок Навигация
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/']") // Ссылка Объявления
	private WebElement wAdvert;
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/catalog/']/span[contains(text(),'Каталог объявлений')]") // Создать объявление
	private WebElement wCatalogAdvert;
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/premium/']/span[contains(text(),'Создать премиум')]") // Создать премиум
	private WebElement wCreatePremium;
	@SuppressWarnings("unused")
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Категории каталога')]")
	private WebElement wCategoryCatalog;
	
	// Авто
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Авто и мото')]")
	private WebElement wAutoMain;
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Легковые автомобили')]")
	private WebElement wEasyCar;		
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Автомобили с пробегом')]")
	private WebElement wEasyCarOld;
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'авто с пробегом')]")
	private WebElement wEasyCarOld_1;
	
	// Отдам даром
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]")
	private WebElement wTakeFree;
	@FindBy(xpath="//ul[@class='x-tree-root-ct x-tree-lines']//ul/li[22]/ul//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]")
	private WebElement wTakeFree_1;
	
	@FindBy(xpath="//button[@class='x-btn-text icon-plus' and contains(text(),'Создать')]")  // кнопка Создать для обычных объявлений
	private WebElement wButtonCreateAdvert;
	
	//	окно выбора региона
	@FindBy(xpath="//span[@class='x-window-header-text' and contains(text(),'Редактирование')]")
	private WebElement wTitledWindowRegion;
	@FindBy(xpath="//fieldset[@class=' x-fieldset x-fieldset-noborder x-form-label-left']//input[2]")
	private WebElement wFieldWindowRegion;
	@FindBy(xpath="//div[@class='x-window-footer']//button[contains(text(),'Сохранить')]")
	private WebElement wButtonSaveWindowRegion;
	
	//  Кнопка сохранить премиум
	@FindBy(xpath="//div[@class='x-panel-bbar x-panel-bbar-noborder']//button[contains(text(),'Сохранить')]")
	private WebElement wButtonSavePremium;
	//  Кнопка сохранить обычное объявление
	@FindBy(xpath="//div[@class='x-tab-panel-footer']//button[contains(text(),'Сохранить')]")
	private WebElement wButtonSaveAdvert;
	// Кнопка на попап окне
	@FindBy(xpath="//div[@class='x-window x-window-plain x-window-dlg']//button[contains(text(),'OK')]")
	private WebElement wButtonWindowPopup;
	
	/*
	 div[@id='propspanel']/div/div/div/div[2]/div/div/div/div[2]/div  / дальше тот /div[1,2,3,4,5 и т д]/ в котором наша строка 
	 потом /table/tbody/tr/td[3]/
	 	 
	 td[@class='x-grid3-col x-grid3-cell x-grid3-td-value x-grid3-cell-last  x-grid3-cell-selected'] путь к диву ввода
	 */
		
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]")
	private WebElement wDivTitleRegion;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Текст объявления')]")
	private WebElement wDivDescription;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Цена')]")
	private WebElement wDivTitlePrice;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Валюта')]")
	private WebElement wDivTitleCurrency;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]")
	private WebElement wDivTitleOwnerAdvert;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Марка')]")
	private WebElement wDivTitleMake;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Модель')]")
	private WebElement wDivTitleModel;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Год выпуска')]")
	private WebElement wDivTitleYear;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип кузова')]")
	private WebElement wDivTitleTypeOfBody;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип трансмиссии')]")
	private WebElement wDivTitleTypeOfTransmission;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Статус модерации')]")
	private WebElement wDivStatusOfModer;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]")
	private WebElement wDivActionOfAdvet;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Заголовок')]")
	private WebElement wDivTitleTitle;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Текст')]")
	private WebElement wDivText;
	
	public Page_Stargate(WebDriver driver){super(driver);}
	
	
	
	public void OpenFormCreatePremiumFree() throws ExceptFailTest
	{
		
		OpenListPremium();
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Категории каталога')]");
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]");
		DoubleClickElement(wTakeFree);
		CheckElementPresent(1,"//ul[@class='x-tree-root-ct x-tree-lines']//ul/li[22]/ul//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]");
		DoubleClickElement(wTakeFree_1);
		Sleep(2000);
	}

	public void OpenFormCreateAdvertFree() throws ExceptFailTest
	{
		
		OpenListAdvert();
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]");
		DoubleClickElement(wTakeFree);
		CheckElementPresent(1,"//ul[@class='x-tree-root-ct x-tree-lines']//ul/li[22]/ul//a[@class='x-tree-node-anchor']/span[contains(text(),'Отдам даром')]");
		DoubleClickElement(wTakeFree_1);
		CheckElementPresent(1, "//button[@class='x-btn-text icon-plus' and contains(text(),'Создать')]");
		CheckCssElement("color","rgba(68, 68, 68, 1)",wButtonCreateAdvert);
		wButtonCreateAdvert.click();
		CheckElementPresent(1,"//div[contains(text(),'Отдам даром')]");
		Sleep(2000);
	}
	
	public void OpenFormCreatePremiumAuto() throws ExceptFailTest
	{
		OpenListPremium();
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Категории каталога')]");
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Авто и мото')]");
		DoubleClickElement(wAutoMain);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Легковые автомобили')]");
		DoubleClickElement(wEasyCar);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Автомобили с пробегом')]");
		DoubleClickElement(wEasyCarOld);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'авто с пробегом')]");
		DoubleClickElement(wEasyCarOld_1);
		//CheckElementPresent(1,"//div[contains(text(),'Авто и мото -> Легковые автомобили -> Автомобили с пробегом')]");
		Sleep(2000);
	}
	
	public void OpenFormCreateAdvertAuto() throws ExceptFailTest
	{
		OpenListAdvert();
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Категории каталога')]");
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Авто и мото')]");
		DoubleClickElement(wAutoMain);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Легковые автомобили')]");
		DoubleClickElement(wEasyCar);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'Автомобили с пробегом')]");
		DoubleClickElement(wEasyCarOld);
		CheckElementPresent(1,"//a[@class='x-tree-node-anchor']/span[contains(text(),'авто с пробегом')]");
		DoubleClickElement(wEasyCarOld_1);
		CheckElementPresent(1, "//button[@class='x-btn-text icon-plus' and contains(text(),'Создать')]");
		CheckCssElement("color","rgba(68, 68, 68, 1)",wButtonCreateAdvert);
		wButtonCreateAdvert.click();
		CheckElementPresent(1,"//div[contains(text(),'Авто и мото -> Легковые автомобили -> Автомобили с пробегом')]");
		Sleep(2000);
	}
		
	public void InputDataFree() throws ExceptFailTest
	{
		wLog.WriteString(1, "Создаем объявление в рубрике \"Отдам даром\"");
		System.out.println("Создаем объявление в рубрике \"Отдам даром\"");
		wLog.WriteString(1, "Вводим регион");
		System.out.println("Вводим регион");
		InputDataToElement(wDivTitleRegion, "region" , "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим заголовок");
		System.out.println("Вводим заголовок");
		InputDataToElement(wDivTitleTitle, "title", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Заголовок')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим текст объявления");
		System.out.println("Вводим текст объявления");
		InputDataToElement(wDivText, "textAdvert", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Текст')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим email владельца объявления");
		System.out.println("Вводим email владельца объявления");
		InputDataToElement(wDivTitleOwnerAdvert, "email", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]");
		Sleep(200);
		wLog.WriteString(1, "Вводим статус активности объявления");
		System.out.println("Вводим статус активности объявления");
		InputDataToElement(wDivActionOfAdvet, "actionOfAdvet", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим статус модерации объявления");
		System.out.println("Вводим статус модерации объявления");
		InputDataToElement(wDivStatusOfModer, "statusOfModer", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Статус модерации')]");
		Sleep(100);
		wLog.WriteString(1, "Сохраняем введенные данные");
		System.out.println("Сохраняем введенные данные");
		if(Proper.GetProperty("typeAdvert").equals("premium"))
		{
			CheckElementPresent(1,"//div[@class='x-panel-bbar x-panel-bbar-noborder']//button[contains(text(),'Сохранить')]");
			ScrollToElement(wButtonSavePremium);
			wButtonSavePremium.click();
			CheckElementPresent(1,"//div[@class='x-window x-window-plain x-window-dlg']//button[contains(text(),'OK')]");
			wButtonWindowPopup.click();
		}
		else
		{
			CheckElementPresent(1,"//div[@class='x-tab-panel-footer']//button[contains(text(),'Сохранить')]");
			wButtonSaveAdvert.click();	
		}
		Sleep(2000);
		wLog.WriteString(1, "Проверяем создано ли объявление");
		System.out.println("Проверяем создано ли объявление");
		if(driver.findElement(By.xpath("//div[contains(text(),'Отдам даром')]")).isDisplayed())
		{
			wLog.WriteString(2, "Объявление в рубрику \"Отдам даром\" не подано");
			System.out.println("Объявление в рубрику \"Отдам даром\" не подано");
			throw new ExceptFailTest("Объявление в рубрику \"Отдам даром\" не подано");
		}
		wLog.WriteString(1, "Объявление создано");
		System.out.println("Объявление создано");
		wLinkLogout.click();
		
	}
	
	public void InputDataAuto() throws ExceptFailTest
	{
		wLog.WriteString(1, "Создаем объявление в рубрике \"Авто с пробегом\"");
		System.out.println("Создаем объявление в рубрике \"Авто с пробегом\"");
		wLog.WriteString(1, "Вводим регион");
		System.out.println("Вводим регион");
		InputDataToElement(wDivTitleRegion, "region", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим текст объявления");
		System.out.println("Вводим текст объявления");
		InputDataToElement(wDivDescription, "textAdvert", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Текст объявления')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим ценy");
		System.out.println("Вводим цену");
		InputDataToElement(wDivTitlePrice, "price", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Цена')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим валюту");
		System.out.println("Вводим валюту");
		InputDataToElement(wDivTitleCurrency, "currency", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Валюта')]");
		Sleep(200);
		wLog.WriteString(1, "Вводим email владельца объявления");
		System.out.println("Вводим email владельца объявления");
		InputDataToElement(wDivTitleOwnerAdvert, "email", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]");
		Sleep(200);
		wLog.WriteString(1, "Вводим марку");
		System.out.println("Вводим марку");
		InputDataToElement(wDivTitleMake, "make", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Марка')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим модель");
		System.out.println("Вводим модель");
		InputDataToElement(wDivTitleModel, "model", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Модель')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим год выпуска");
		System.out.println("Вводим год выпуска");
		InputDataToElement(wDivTitleYear, "year", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Год выпуска')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим тип кузова");
		System.out.println("Вводим тип кузова");
		InputDataToElement(wDivTitleTypeOfBody, "typeOfBody", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип кузова')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим тип трансмиссии");
		System.out.println("Вводим тип трансмиссии");
		InputDataToElement(wDivTitleTypeOfTransmission, "typeOfTransmission", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип трансмиссии')]");
		Sleep(100);
		wLog.WriteString(1, "Вводим статус активности объявления");
		System.out.println("Вводим статус активности объявления");
		InputDataToElement(wDivActionOfAdvet, "actionOfAdvet", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]");
		wLog.WriteString(1, "Сохраняем введенные данны");
		System.out.println("Сохраняем введенные данные");
		if(Proper.GetProperty("typeAdvert").equals("premium"))
		{
			CheckElementPresent(1,"//div[@class='x-panel-bbar x-panel-bbar-noborder']//button[contains(text(),'Сохранить')]");
			ScrollToElement(wButtonSavePremium);
			wButtonSavePremium.click();
			CheckElementPresent(1,"//div[@class='x-window x-window-plain x-window-dlg']//button[contains(text(),'OK')]");
			wButtonWindowPopup.click();
		}
		else
		{
			CheckElementPresent(1,"//div[@class='x-tab-panel-footer']//button[contains(text(),'Сохранить')]");
			wButtonSaveAdvert.click();
		}
		Sleep(2000);
		wLog.WriteString(1, "Проверяем создано ли объявление");
		System.out.println("Проверяем создано ли объявление");
		if(driver.findElement(By.xpath("//div[contains(text(),'Авто и мото -> Легковые автомобили -> Автомобили с пробегом')]")).isDisplayed())
		{
			wLog.WriteString(2, "Объявление в рубрику \"Автомобили с пробегом\" не подано");
			System.out.println("Объявление в рубрику \"Автомобили с пробегом\" не подано");
			throw new ExceptFailTest("Объявление в рубрику \"Автомобили с пробегом\" не подано");
		}
		wLog.WriteString(1, "Объявление создано");
		System.out.println("Объявление создано");
		driver.get(driver.getCurrentUrl());
	}
	    
	// ввод региона
	private void SetRegion(String sNameRegion) throws ExceptFailTest
	{
		//System.out.println("Для региона");
		String sRegion = Proper.GetProperty(sNameRegion); // получили значени из файла конфига назание региона
		String s1 = "//div[contains(text(),'"+sRegion+"  (')]"; // получили xpath выпадающео списка региона 
		CheckElementPresent(1,"//fieldset[@class=' x-fieldset x-fieldset-noborder x-form-label-left']//input[2]"); // проверяем что поле ввоа региона существует
		wFieldWindowRegion.sendKeys(sRegion);
		CheckElementPresent(1,s1); // проверяем что появился выпадающий список с регионами
		WebElement wListSaveWindowRegion = driver.findElement(By.xpath(s1)); // получаем его значение 
		wListSaveWindowRegion.click(); // выбираем его
		CheckElementPresent(1,"//div[@class='x-window-footer']//button[contains(text(),'Сохранить')]"); //проверяем что есть кнопка сохранить 
		wButtonSaveWindowRegion.click(); // сохраняем
	}
	
	// ввод других значении в элементе img
	private void SetOtherImageDiv(String sNameField) throws ExceptFailTest
	{
		//System.out.println("Для остальных");
		String sDataField = Proper.GetProperty(sNameField); // получили значение из файла конфига для ввода
		String s1 = "//div[@class='x-combo-list-inner']/div[contains(text(),'"+sDataField+"')]"; // получили xpath значения в выпадающем списке со значениями
		CheckElementPresent(1,s1); // проверяем что появился выпадающий список со значением нужным
		WebElement wListElement = driver.findElement(By.xpath(s1)); // получаем элемент со значением
		wListElement.click();
	}
	
	// ввод значений если элемент ввода img
	private void SetDropDownList(WebElement wElement, String sNameField) throws ExceptFailTest
	{
		//System.out.println("Сработал SetDropDownList");
		try  // проверям если выпадающий список еще не открыт 
		{
			String sDataField = Proper.GetProperty(sNameField); // получили значение из файла конфига для ввода
			String s1 = "//div[@class='x-combo-list-inner']/div[contains(text(),'"+sDataField+"')]"; 
			if(!driver.findElement(By.xpath(s1)).isDisplayed())  // и элемент который надо выбрать не отображается
				wElement.click(); // нажимаем что бы список отобразился
		}
		catch(NoSuchElementException exc){wElement.click();} // иначе если его нет жмем

		if(wTitledWindowRegion.isDisplayed()) // если открывается окно выбора регионов (у него заголовок "Редактировать")
			SetRegion(sNameField); // вводим регион
		else
		{
			SetOtherImageDiv(sNameField);
		}
	}
	
	private void SetInput(WebElement wElement, String sNameField)
	{
		//System.out.println("Сработал SetInput");
		String sDataField = Proper.GetProperty(sNameField);
		wElement.clear();
		wElement.sendKeys(sDataField);
		
	}
	
	// ввод значений если элемент ввода textarea
	private void SetTextArea(WebElement wElement, String sNameField)
	{
		//System.out.println("Сработал SetTextArea");
		String sDataField = Proper.GetProperty(sNameField);
		wElement.clear();
		wElement.sendKeys(sDataField);	
	}
	
	// ввод значений если элемент ввода select
	private void SetSelect(WebElement wElement, String sNameField)
	{
		//System.out.println("Сработал SetSelect");
		String sDataField = Proper.GetProperty(sNameField);
		List<WebElement> allOptions = wElement.findElements(By.tagName("option"));
		for(WebElement wE : allOptions)
		{
			if(wE.getText().equals(sDataField))
				wE.click();
		}
	}
		
	private void InputDataToElement(WebElement wElement, String sNameField , String sPath) throws ExceptFailTest
	{  	
		CheckElementPresent(1, sPath);
		ScrollToElement(wElement); //скролим к заголовку нужного  поля
		wElement.click(); //выделяем его
		KeyPress(wElement, Keys.ARROW_RIGHT, 1); // переходим на соседнюю строку (в ней элементы ввода) 
		CheckElementPresent(1,"//td[contains(@class,'x-grid3-cell-selected')]"); // проверяем что wTdSecondFields доступен
		WebElement wTdSecondFields = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-cell-selected')]")); // вторая строка от заголовка (поле где вводим)
		if(Proper.GetProperty("typeAdvert").equals("premium"))
			wTdSecondFields.click();
		else DoubleClickElement(wTdSecondFields);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// проверяем какой элемент появился в строке для ввода
		try // проверка наличия активного выпадающего списка img
		{
			WebElement wImageArrow = driver.findElement(By.xpath("//div[contains(@class,'x-trigger-wrap-focus')]/img")); 
			if(wImageArrow.isDisplayed())										
			{	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				SetDropDownList(wImageArrow, sNameField);
				return;
			}
		}
		catch(NoSuchElementException exc){/*System.out.println("Нет ниодного активнного дроплиста картинки");*/}
		
		try // проверка наличия активного инпута
		{
			WebElement wInput = driver.findElement(By.xpath("//input[contains(@class,'x-form-focus')]"));
			if(wInput.isDisplayed())										
			{
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				SetInput(wInput, sNameField);
				return;
			}
		}
		catch(NoSuchElementException exc){/*System.out.println("Нет ниодного активнного инпута");*/}
		
		try // проверка наличия активного селекта
		{
			WebElement wSelect = driver.findElement(By.xpath("//select[contains(@class,'x-form-focus')]"));
			if(wSelect.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				SetSelect(wSelect, sNameField);
				return;
			}
		}
		catch(NoSuchElementException exc){/*System.out.println("Нет ниодного активнного селекта");*/}
		
		try // проверка наличия активного текстареа
		{
			WebElement wArea = driver.findElement(By.xpath("//textarea[contains(@class, 'x-form-focus')]"));
			if(wArea.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				SetTextArea(wArea, sNameField);
				return;
			}
		}
		catch(NoSuchElementException exc){/*System.out.println("Нет ниодного активнного текстареа");*/}
	}

	@Override
	public void OpenPage(){}
	
	private void OpenListAdvert() throws ExceptFailTest  //Открытие листинга выбора рубрики добавления обычного объявления
	{
		Sleep(1000);
		wLog.WriteString(1, "Проверяем вошли ли");
		System.out.println("Проверяем вошли ли");
		CheckElementPresent(1, "//a[@href='/stargate/workspace/admanagement/']");
		wLog.WriteString(1, "Вошли");
		System.out.println("Вошли");
		wAdvert.click();
		Sleep(1000);
		CheckElementPresent(1,"//a[@href='/stargate/workspace/admanagement/catalog/']/span[contains(text(),'Каталог объявлений')]");
		wLog.WriteString(1, "Открываем форму создания объявления");
		System.out.println("Открываем форму создания объявления");
		wCatalogAdvert.click();
		Sleep(1000);
	}
	
	private void OpenListPremium() throws ExceptFailTest//Открытие листинга выбора рубрики добавления премиум объявления
	{
		Sleep(1000);
		wLog.WriteString(1, "Проверяем вошли ли");
		System.out.println("Проверяем вошли ли");
		CheckElementPresent(1, "//a[@href='/stargate/workspace/admanagement/']");
		wLog.WriteString(1, "Вошли");
		System.out.println("Вошли");
		wAdvert.click();
		Sleep(1000);
		CheckElementPresent(1,"//a[@href='/stargate/workspace/admanagement/premium/']//span[contains(text(),'Создать премиум')]");
		wLog.WriteString(1, "Открываем форму создания премиума");
		System.out.println("Открываем форму создания премиума");
		wCreatePremium.click();
		Sleep(1000);
	}
}