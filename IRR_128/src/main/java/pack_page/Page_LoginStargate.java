package pack_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pack_utils.ExceptFailTest;
import pack_utils.Proper;

public class Page_LoginStargate extends Page
{
	
	String sUrlStargate="";
	
	@FindBy(id="ext-comp-1003")             
	private WebElement inputLogin;
	
	@FindBy(id="ext-comp-1004")
	private WebElement inputPassword;
	
	@FindBy(id="ext-gen31")
	private WebElement buttonEnter;
	
	@FindBy(id="ext-comp-1009")
	private WebElement tableButton;
	
	
	public Page_LoginStargate(WebDriver driver)
	{
		super(driver);	
	}

	public void OpenPage(String sUrl) throws ExceptFailTest
	{
		driver.get(sUrl);
		driver.manage().window().maximize();
		System.out.println("Открываем страницу "+sUrl);
		wLog.WriteString(1, "Открываем страницу "+sUrl);
	}

	public void CheckElements() throws ExceptFailTest
	{
		wLog.WriteString(1, "Авторизуемся");
		System.out.println("Авторизуемся");
		CheckElementPresent(2,"ext-comp-1003");
		CheckElementPresent(2,"ext-comp-1004");
		CheckElementPresent(2,"ext-gen31");
	}
	
	public void TypeLoginPassword(String sLogin, String sPassword) throws ExceptFailTest
	{
		inputLogin.clear();
		inputLogin.sendKeys(sLogin);
		wLog.WriteString(1, "Вводим логин");
		System.out.println("Вводим логин");
		inputPassword.clear();
		inputPassword.sendKeys(sPassword);
		wLog.WriteString(1, "Вводим пароль");
		System.out.println("Вводим пароль");
	}
	
	public Page_Stargate EnterStargate() throws ExceptFailTest
	{
		CheckAtributeElement("class", "x-btn-wrap x-btn ", tableButton);
		buttonEnter.click();
		wLog.WriteString(1, "Нажимаем войти");
		System.out.println("Нажимаем войти");
		return PageFactory.initElements(driver, Page_Stargate.class);
	}
	
}
