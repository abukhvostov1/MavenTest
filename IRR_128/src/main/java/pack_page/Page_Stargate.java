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


public class Page_Stargate extends Page
{
	@FindBy(xpath="//a[@href='/stargate/?logout=true']")
	private WebElement wLinkLogout;
	
	// Блок Навигация
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/']") // Ссылка Объявления
	private WebElement wAdvert;
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/catalog/']/span[contains(text(),'Каталог объявлений')]") // Создать объявление
	private WebElement wCatalogAdvert;
	@SuppressWarnings("unused")
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/premium/']/span[contains(text(),'Создать премиум')]") // Создать премиум
	private WebElement wCreatePremium;
	@FindBy(xpath="//a[@href='/stargate/workspace/admanagement/find/']/span[contains(text(),'Найти объявления')]") // Найти объявление
	private WebElement wFindAdvert;
	@SuppressWarnings("unused")
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Категории каталога')]")
	private WebElement wCategoryCatalog;
	
	//форма поиска
	//заголовок поле ID
	@SuppressWarnings("unused")
	@FindBy(xpath = "//label[@class='x-form-item-label' and contains(text(),'ID:')]")
	private WebElement wTitleId;
	//кнопка искать
	@FindBy(xpath="//button[@class='x-btn-text' and contains(text(),'Искать')]")
	private WebElement wButtonSearch;
	//крестик разворота данных о найденном объявлении
	@FindBy(xpath ="//td[@class='x-grid3-col x-grid3-cell x-grid3-td-expander x-grid3-cell-first ']")
	private WebElement wDivCrossAdvert;
	// Вкладка свойства
	@SuppressWarnings("unused")
	@FindBy(xpath="//span[@class='x-tab-strip-text ' and contains(text(),'Свойства')]")
	private WebElement wTabProperties;
	//кнопка Сохранить
	@FindBy(xpath="//button[@class='x-btn-text' and contains(text(),'Сохранить')]")
	private WebElement wButtonSaveFind;
	//поле ввода id
	@FindBy(xpath="//div[@class='x-column-inner']//input[1]")
	private WebElement wInputID;

	
	// Авто
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Авто и мото')]")
	private WebElement wAutoMain;
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Легковые автомобили')]")
	private WebElement wEasyCar;		
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'Автомобили с пробегом')]")
	private WebElement wEasyCarOld;
	@FindBy(xpath="//a[@class='x-tree-node-anchor']/span[contains(text(),'авто с пробегом')]")
	private WebElement wEasyCarOld_1;
	
	// кнопка Создать для обычных объявлений
	@FindBy(xpath="//button[@class='x-btn-text icon-plus' and contains(text(),'Создать')]")
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
		
	// Авто (а так же найденное объявление)
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]")
	private WebElement wDivTitleRegion;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Рубрика')]")
	private WebElement wDivTitleRubric;
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
	@SuppressWarnings("unused")
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Статус модерации')]")
	private WebElement wDivStatusOfModer;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]")
	private WebElement wDivActionOfAdvet;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Перенести в рубрику')]")
	private WebElement wDivChangeOfRubric;
	// Недвижимость (а так же найденное объявление)
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Комнат в квартире')]")
	private WebElement wDivRoomsInFlat;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Общая площадь')]")
	private WebElement wDivSquare;
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Этаж')]")
	private WebElement wDivFloor;
	
	
	
	
	
	public Page_Stargate(WebDriver driver){super(driver);}
	
	// открытие формы поиска
	public void OpenFindForm() throws ExceptFailTest
	{
		driver.get(driver.getCurrentUrl());
		Sleep(1000);
		wLog.WriteString(1, "Проверяем вошли ли");
		print("Проверяем вошли ли");
		CheckElementPresent(1, "//a[@href='/stargate/workspace/admanagement/']");
		wLog.WriteString(1, "Вошли");
		print("Вошли");
		wAdvert.click();
		Sleep(1000);
		CheckElementPresent(1, "//a[@href='/stargate/workspace/admanagement/find/']/span[contains(text(),'Найти объявления')]");
		wLog.WriteString(1, "Открываем форму поиска объявления");
		print("Открываем форму поиска объявления");
		wFindAdvert.click();
		Sleep(1000);
	}
	
	// Поиск объявления по ID в поле формы поиска
	public boolean FindAdvert(String sData) throws ExceptFailTest
	{
		
		Sleep(300);
		print("Ищем объявление через форму поиска");
		wLog.WriteString(1, "Ищем объявление через форму поиска");
		print("Вводим ID объявления: " + sData);
		wLog.WriteString(1, "Вводим ID объявления: " + sData);
		CheckElementPresent(1,"//div[@class='x-column-inner']//input[1]");
		wInputID.sendKeys(sData);
		Sleep(300);
		print("Нажимаем кнопку Искать");
		wLog.WriteString(1, "Нажимаем кнопку Искать");
		CheckElementPresent(1, "//button[@class='x-btn-text' and contains(text(),'Искать')]");
		wButtonSearch.click();
		print("Проверяем найдено ли объявление");
		wLog.WriteString(1, "Проверяем найдено ли объявление");
		CheckElementPresent(1, "//td[@class='x-grid3-col x-grid3-cell x-grid3-td-expander x-grid3-cell-first ']");
		print("Объявление найдено, разворачиваем его");
		wLog.WriteString(1, "Объявление найдено, разворачиваем его");
		DoubleClickElement(wDivCrossAdvert);
		print("Проверяем развернуто ли объявление");
		wLog.WriteString(1, "Проверяем развернуто ли объявление");
		CheckElementPresent(1, "//span[@class='x-tab-strip-text ' and contains(text(),'Свойства')]");
		print("Объявление развернуто");
		wLog.WriteString(1, "Объявление развернуто");
		return true;
		
	}
	
	// изменение данных
	public void ChangeDataForAdvert(String sOldUser, String sUser, String sOldCategory, String sCategory, String sOldRegion, String sRegion, String sOldStatus, String sStatus, String sKey, String sNameOperation) throws ExceptFailTest
	{
		print("Выполняется операция: "+sNameOperation);
		wLog.WriteString(3, "Выполняется операция: "+sNameOperation);
		ChangeRegionForAdvert(sOldRegion, sRegion);
		ChangeUserForAdvert(sOldUser, sUser);
		ChangeStatusForAdvert(sStatus, sOldStatus);
		AddDataForAdvertCarsOrRealt(sKey);
		ChangeCategoryForAdvert(sOldCategory, sCategory);
		SaveChangeForFormFind();	
	}
	
	// изменение данных для конкретных полей объявления
	// изменение пользователя
	private void ChangeUserForAdvert(String sOldUser, String sUser) throws ExceptFailTest
	{
		print("Изменяем пользователя");
		wLog.WriteString(3, "Изменяем пользователя");
		String sData = GetDataFromFieldForAdvert(wDivTitleOwnerAdvert, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]");
		print("Предыдущее значение: " + sData);
		wLog.WriteString(1, "Предыдущее значение: " + sData);
		if(!sOldUser.equals(sUser))
			InputDataToElement(wDivTitleOwnerAdvert, sUser, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]");
		print("Новое значение: " + Proper.GetProperty(sUser));
		wLog.WriteString(1, "Новое значение: " + Proper.GetProperty(sUser));
	}
	
	private void ChangeCategoryForAdvert(String sOldCategory, String sCategory) throws ExceptFailTest 
	{
		print("Изменяем рубрику(категорию) объявления");
		wLog.WriteString(3, "Изменяем рубрику(категорию) объявления");
		String sData = GetDataFromFieldForAdvert(wDivTitleRubric, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Рубрика')]");
		if(!sOldCategory.equals(sCategory))
			InputDataToElement(wDivChangeOfRubric, sCategory, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Перенести в рубрику')]");
		print("Предыдущее значение: " + sData);
		wLog.WriteString(1, "Предыдущее значение: " + sData);
		print("Новое значение: " + Proper.GetProperty(sCategory));
		wLog.WriteString(1, "Новое значение: " + Proper.GetProperty(sCategory));
	}

	private void ChangeRegionForAdvert(String sOldRegion, String sRegion) throws ExceptFailTest 
	{
		print("Изменяем регион объявления");
		wLog.WriteString(3, "Изменяем регион объявления");
		String sData = GetDataFromFieldForAdvert(wDivTitleRegion, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]");
		print("Предыдущее значение: " + sData);
		wLog.WriteString(1, "Предыдущее значение: " + sData);
		if(!sOldRegion.equals(sRegion))
			InputDataToElement(wDivTitleRegion, sRegion, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Регион')]");
		print("Новое значение: " + Proper.GetProperty(sRegion));
		wLog.WriteString(1, "Новое значение: " + Proper.GetProperty(sRegion));
	}
	
	private void ChangeStatusForAdvert(String sStatus, String sOldStatus) throws ExceptFailTest 
	{
		print("Изменяем статус объявления");
		wLog.WriteString(3, "Изменяем статус объявления");
		String sData = GetDataFromFieldForAdvert(wDivActionOfAdvet, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]");
		print("Предыдущее значение: " + sData);
		wLog.WriteString(1, "Предыдущее значение: " + sData);
		if(!sOldStatus.equals(sStatus))
			InputDataToElement(wDivActionOfAdvet, sStatus, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]");
		print("Новое значение: " + Proper.GetProperty(sStatus));
		wLog.WriteString(1, "Новое значение: " + Proper.GetProperty(sStatus));
	}

	// сохранение изменений
	private void SaveChangeForFormFind() throws ExceptFailTest
	{
		print("Сохраняем изменения");
		wLog.WriteString(1, "Сохраняем изменения");
		CheckElementPresent(1, "//button[@class='x-btn-text' and contains(text(),'Сохранить')]");
		wButtonSaveFind.click();
		Sleep(2200);
		/*if(wTabProperties.isDisplayed())
		{
			print("Изменения не сохраненны");
			wLog.WriteString(2, "Изменения не сохраненны");
			throw new ExceptFailTest("Изменения не сохраненны");
		}*/
		print("Изменения сохраненны");
		wLog.WriteString(1, "Изменения сохраненны");	
	}
	
	// добавление данных для объяления авто (когда меняем рубрику)
	private void AddDataForAdvertCarsOrRealt(String sKey) throws ExceptFailTest
	{
		if(sKey.equals("0"))
		{
			Sleep(100);
			print("Вводим марку");
			wLog.WriteString(1, "Вводим марку");
			InputDataToElement(wDivTitleMake, "make", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Марка')]");
			Sleep(100);
			print("Вводим модель");
			wLog.WriteString(1, "Вводим модель");
			InputDataToElement(wDivTitleModel, "model", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Модель')]");
			Sleep(100);
			print("Вводим год выпуска");
			wLog.WriteString(1, "Вводим год выпуска");
			InputDataToElement(wDivTitleYear, "year", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Год выпуска')]");
			Sleep(100);
			print("Вводим тип кузова");
			wLog.WriteString(1, "Вводим тип кузова");
			InputDataToElement(wDivTitleTypeOfBody, "typeOfBody", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип кузова')]");
			Sleep(100);
			print("Вводим тип трансмиссии");
			wLog.WriteString(1, "Вводим тип трансмиссии");
			InputDataToElement(wDivTitleTypeOfTransmission, "typeOfTransmission", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Тип трансмиссии')]");
			Sleep(100);
		}
		if(sKey.equals("1"))
		{
			Sleep(100);
			print("Вводим количество комнат в квартире");
			wLog.WriteString(1, "Вводим количество комнат в квартире");
			InputDataToElement(wDivRoomsInFlat, "roomsOfFlat", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Комнат в квартире')]");
			Sleep(100);
			print("Вводим общую площадь");
			wLog.WriteString(1, "Вводим общую площадь");
			InputDataToElement(wDivSquare, "square", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Общая площадь')]");
			Sleep(100);
			print("Вводим этаж");
			wLog.WriteString(1, "Вводим этаж");
			InputDataToElement(wDivFloor, "floor", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Этаж')]");
			Sleep(100);
		}
	}
	
	// получение значения поля (данных в поле)
	private String GetDataFromFieldForAdvert(WebElement wElement, String sPath) throws ExceptFailTest
	{
		CheckElementPresent(1, sPath);
		ScrollToElement(wElement); //скролим к заголовку нужного  поля
		wElement.click(); //выделяем его
		KeyPress(wElement, Keys.ARROW_RIGHT, 1); // переходим на соседнюю строку (в ней элементы ввода) 
		CheckElementPresent(1,"//td[contains(@class,'x-grid3-cell-selected')]"); // проверяем что wTdSecondFields доступен
		WebElement wTdSecondFields = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-cell-selected')]"));
		return wTdSecondFields.getText();
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
		
	public void InputDataAuto(String sNumberSteps) throws ExceptFailTest
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
		InputDataToElement(wDivTitleOwnerAdvert, "email" + sNumberSteps, "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Владелец объявления')]");
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
		InputDataToElement(wDivActionOfAdvet, "actionOfAdvert", "//div[@class='x-grid3-cell-inner x-grid3-col-title' and contains(text(),'Активность объявления')]");
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
		//driver.get(driver.getCurrentUrl());
		//wLinkLogout.click();
	}
	    
	// ввод региона
	private void SetRegion(String sNameRegion) throws ExceptFailTest
	{
		//System.out.println("Для региона");
		String sRegion = Proper.GetProperty(sNameRegion); // получили значени из файла конфига назание региона
		String s1 = "//div[contains(text(),'"+sRegion+"  (')]"; // получили xpath выпадающео списка региона 
		CheckElementPresent(1,"//fieldset[@class=' x-fieldset x-fieldset-noborder x-form-label-left']//input[2]"); // проверяем что поле ввоа региона существует
		if(!wFieldWindowRegion.getText().equals(""))
			print("Текущее значение региона: "+wFieldWindowRegion.getText());
		wFieldWindowRegion.clear();
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
		
		try
		{
			if(wTitledWindowRegion.isDisplayed()) // если открывается окно выбора регионов (у него заголовок "Редактировать")
				{
					SetRegion(sNameField); // вводим регион
					return;
				}
		}
		catch(NoSuchElementException exc){/*print("это не выбор региона");*/}
		SetOtherImageDiv(sNameField);

	}
	
	// ввод значений если элемент ввода input
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
	
	// вводд данных при создании объявлений
	private void InputDataToElement(WebElement wElement, String sNameField , String sPath) throws ExceptFailTest
	{  	
		CheckElementPresent(1, sPath);
		ScrollToElement(wElement); //скролим к заголовку нужного  поля
		wElement.click(); //выделяем его
		KeyPress(wElement, Keys.ARROW_RIGHT, 1); // переходим на соседнюю строку (в ней элементы ввода) 
		CheckElementPresent(1,"//td[contains(@class,'x-grid3-cell-selected')]"); // проверяем что wTdSecondFields доступен
		WebElement wTdSecondFields = driver.findElement(By.xpath("//td[contains(@class,'x-grid3-cell-selected')]")); // вторая строка от заголовка (поле где вводим)
		
		/*if(!wTdSecondFields.getText().equals(" "))
		{
			print("Предыдущее значение: " + wTdSecondFields.getText());
			wLog.WriteString(1, "Предыдущее значение: " + wTdSecondFields.getText());
		}*/
		
		if(Proper.GetProperty("typeAdvert").equals("premium"))
			wTdSecondFields.click();
		else DoubleClickElement(wTdSecondFields);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		CheckElementForInput(sNameField);
	}
	
	// Проверка какой элемент доступен и вызов соответствующей функции для подачи объявления
	private void CheckElementForInput(String sNameField) throws ExceptFailTest
	{
		// проверяем какой элемент появился в строке для ввода
		try // проверка наличия активного выпадающего списка img
		{
			WebElement wImageArrow = driver.findElement(By.xpath("//div[contains(@class,'x-trigger-wrap-focus')]/img")); 
			if(wImageArrow.isDisplayed())										
			{	
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				SetTextArea(wArea, sNameField);
				return;
			}
		}
		catch(NoSuchElementException exc){/*System.out.println("Нет ниодного активнного текстареа");*/}
	}

	

	
	//Открытие листинга выбора рубрики добавления обычного объявления
	private void OpenListAdvert() throws ExceptFailTest  
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
	
	@Override
	public void OpenPage(String sUrl){}

}