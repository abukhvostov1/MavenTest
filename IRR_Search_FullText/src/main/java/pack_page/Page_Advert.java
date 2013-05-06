package pack_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pack_utils.ExceptFailTest;

public class Page_Advert extends Page
{
	// заголовок объявления
	@FindBy(xpath="//div[@class='wrapTitleLeft cb_header']")
	private WebElement wTitleAdvert;
	// текст объявления
	@FindBy(xpath="//span[@class='advert_text']")
	private WebElement wTextAdvert;
	// ссылка показать все
	@FindBy(xpath="//a[@class='showAll']")
	private WebElement wLinkShowAll;
	// Кастомфилд марка
	@FindBy(xpath="//table[@id='mainParams']//tr[2]/td") // значение марки всегда вторым в списке
	private WebElement wCustomMake;
	
	
	public Page_Advert(WebDriver driver){super(driver);}
	public void OpenPage(String sUrl) {}
	
	
	// получаем заголовок
	public String GetAdvertTitle(String sUrlAdvert) throws ExceptFailTest
	{
		print(sUrlAdvert);
		print("Получаем заголовок объявления:");
		if(!CheckElement("//div[@class='wrapTitleLeft cb_header']", "\"Заголовок объявления\""))
		{
			print("Повторная загрузка старницы");
			driver.get(driver.getCurrentUrl());
		}
		CheckElementPresent(1, "//div[@class='wrapTitleLeft cb_header']");
		return wTitleAdvert.getText();
	}
	// получаем текст объявления
	public String GetAdvertText() throws ExceptFailTest
	{
		print("Получаем текст объявления:");
		print("Проверяем есть ли текст в объявлении");
		if(!CheckElement("//span[@class='advert_text']", "\"Блок с текстом объявления\""))
		{
			print("В объявлении отсутсвует блок с текстом");
			return "";
		}
		print("Текст найден");
		print("Проверяем есть ли ссылка \"Показать все\" ");
		if(CheckElement("//a[@class='showAll']", "ссылка \"Показать все\""))
		{
			print("Ссылка найдена, нажимаем ее");
			ClickElement(wLinkShowAll);
		}
		Sleep(500);
		return wTextAdvert.getText();
	}
	// получаем кастомфилд марка
	public String GetCustomMake(String sUrlAdvert) throws ExceptFailTest
	{
		
		print(sUrlAdvert);
		print("Получаем значение марки в объявлении");
		if(!CheckElement("//table[@id='mainParams']//tr[2]/td", "\"Кастомфилд марка\"")) // если с первого раза нет то повторно обновим страницу
			driver.get(driver.getCurrentUrl());
		CheckElementPresent(1, "//table[@id='mainParams']//tr[2]/td");
		print("Кастомфилд \"марка\" найдена его значение - \"" + wCustomMake.getText() + "\"");
		return wCustomMake.getText();
	}
	
}
