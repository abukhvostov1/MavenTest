package pack_page;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pack_utils.ExceptFailTest;
import pack_utils.Proper;

public abstract class Page {
	protected WebDriver driver;
	protected int nTimeWait; // время ожидания элемента
	protected String sUrl; // урл страницы

	// Конструктор
	public Page(WebDriver driver) {
		this.driver = driver;
		nTimeWait = Integer.parseInt(Proper.GetProperty("nTimeWait"));
		this.driver.manage().timeouts()
				.implicitlyWait(nTimeWait, TimeUnit.SECONDS);
	}

	// Закрытие драйвера
	public void CloseDriver() {
		driver.close();
	}

	// Открытия страницы
	public abstract void OpenPage(String sUrl);

	// Проверка существования элемента
	protected void CheckElementPresent(final int nKey, final String sLocator)
			throws ExceptFailTest {
		WebElement wElement = null;
		WebDriverWait wWaitDriver = new WebDriverWait(driver, nTimeWait);
		try {
			wElement = wWaitDriver.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver wd) {
					WebElement wEl = null;
					switch (nKey) {
					case 1:
						wEl = wd.findElement(By.xpath(sLocator));
						break;
					case 2:
						wEl = wd.findElement(By.id(sLocator));
						break;
					case 3:
						wEl = wd.findElement(By.name(sLocator));
						break;
					case 4:
						wEl = wd.findElement(By.className(sLocator));
						break;
					case 5:
						wEl = wd.findElement(By.linkText(sLocator));
						break;
					case 6:
						wEl = wd.findElement(By.cssSelector(sLocator));
						break;
					}
					return wEl;
				}
			});
		} catch (TimeoutException exc) {
			System.out.println("Элемент " + sLocator + " не найден");
		}
		if (wElement == null) {
			throw new ExceptFailTest("Элемент " + sLocator + " не найден");
		}
	}

	// Даблклик по элементу
	protected void DoubleClickElement(WebElement wElement) {
		Actions builder;
		Action dClick;
		builder = new Actions(driver);
		builder.doubleClick(wElement);
		dClick = builder.build();
		dClick.perform();
	}

	// Клик по элементу
	protected void ClickElement(WebElement wElement) {
		Actions builder;
		Action cClick;
		builder = new Actions(driver);
		builder.click(wElement);
		cClick = builder.build();
		cClick.perform();
	}

	// Нажатие клавиши
	protected void KeyPress(WebElement wElement, Keys key, int n) {
		while (n > 0) {
			wElement.sendKeys(key);
			n--;
		}
	}

	// Ввода текста
	protected void SendText(WebElement wElement, String sText) {
		wElement.clear();
		wElement.sendKeys(sText);
	}

	// Скролл к элементу
	@SuppressWarnings("deprecation")
	protected void ScrollToElement(WebElement wElement) {
		((Locatable) wElement).getLocationOnScreenOnceScrolledIntoView();
	}

	// Снятие скриншота
	protected void CaptureScreenshot(String sName) {
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		//String path = "src\\" + screenshot.getName();
		//System.out.println(path);

		try
		{
			FileUtils.copyFile(screenshot, new File(/*"src\\" + */  sName + ".png"));
		} 
		catch (IOException e) { print("Не удалось сохранить скриншот");}
	}

	// Проверка значения текста элемента
	protected void CheckTextForElement(WebElement wElement, String sText)
			throws ExceptFailTest {
		try {
			if (wElement.getTagName().equals("input"))
				Assert.assertTrue(wElement.getAttribute("value").equals(sText));
			else
				Assert.assertTrue(wElement.getText().equals(sText));
		} catch (AssertionError exc) {
			throw new ExceptFailTest(
					"Значение текста в элементе не совпало с ожидаемым");
		}
	}

	// Проверка css элемента
	protected void CheckCssElement(WebElement wElement, String sPropertyName,
			String sExcpextedCssValue) throws ExceptFailTest {
		try {
			Assert.assertTrue(wElement.getCssValue(sPropertyName).equals(
					sExcpextedCssValue));
		} catch (AssertionError exc) {
			throw new ExceptFailTest("Значение параметра " + sPropertyName
					+ " в элементе не совпало с ожидаемым");
		}
	}

	// Проверка атрибута элемента с ожиданнием
	protected void ChecksAtributeElement(final WebElement wElement,
			final String sAtributeName, final String sExcpextedAtributeValue)
			throws ExceptFailTest {
		boolean bFlag = false;
		WebDriverWait wWaitDriver = new WebDriverWait(driver, nTimeWait);
		try {
			bFlag = wWaitDriver.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wd) {
					String s = wElement.getAttribute(sAtributeName);
					return s.equals(sExcpextedAtributeValue);
				}
			});
		} catch (TimeoutException exc) {
			System.out.println("Элемент c атрибутом " + sExcpextedAtributeValue
					+ " не найден");
		}

		if (!bFlag) {
			throw new ExceptFailTest("Значение параметра " + sAtributeName
					+ " в элементе не совпало с ожидаемым");
		}
	}

	// Проверка доступности/недоступности элемента
	protected void CheckEnableElement(WebElement wElement, int nOperation)
			throws ExceptFailTest {
		switch (nOperation) {
		case 1:
			if (!wElement.isEnabled()) {
				print("Элемент \"" + wElement.getText() + "\" не доступен");
				throw new ExceptFailTest("Элемент \"" + wElement.getText()
						+ "\" не доступен");
			}
			break;
		case 2:
			if (wElement.isEnabled()) {
				print("Элемент \"" + wElement.getText() + "\" доступен");
				throw new ExceptFailTest("Элемент \"" + wElement.getText()
						+ "\" доступен");
			}
			break;
		default:
			print("Операция не определена");
			throw new ExceptFailTest("Операция не определена");
		}
	}

	// Проверка невидимости элемента с ожиданием
	protected void CheckNotVisibleElement(String sLocator, String sName)
			throws ExceptFailTest {
		WebDriverWait wait = new WebDriverWait(driver, nTimeWait);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath(sLocator)));
		} catch (TimeoutException exc) {
			print("Элемент " + sName + " виден.");
			throw new ExceptFailTest("Элемент \"" + sName + "\" виден.");
		}
	}

	// проверка видимости элемента с ожиданием
	protected void CheckVisibleElement(WebElement wElement, String sName) throws ExceptFailTest 
	{
		WebDriverWait wait = new WebDriverWait(driver, nTimeWait);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(wElement));
		} 
		catch (TimeoutException exc)
		{
			print("Элемент " + sName + "не виден.");
			throw new ExceptFailTest("Элемент \"" + sName + "\" не виден.");
		}
	}

	// Поиск и возврат списков элементов по xpath
	protected WebElement[] GetAllWebElements(final String sLocator) throws ExceptFailTest 
	{

		WebElement wTemp[];
		ArrayList<WebElement> list;
		Iterator<WebElement> it;
		int i = 0;
		WebDriverWait wWaitDriver = new WebDriverWait(driver, nTimeWait);

		try {
			list = wWaitDriver
					.until(new ExpectedCondition<ArrayList<WebElement>>() {
						public ArrayList<WebElement> apply(WebDriver wd) {
							return (ArrayList<WebElement>) wd.findElements(By
									.xpath(sLocator));
						}
					});
		} catch (TimeoutException exc) {
			System.out.println("Не один элемент с локатором " + sLocator
					+ " не найден");
			throw new ExceptFailTest("Не один элемент с локатором " + sLocator
					+ " не найден");
		}

		wTemp = new WebElement[list.size()];
		it = list.iterator();

		while (it.hasNext()) {
			wTemp[i] = it.next();
			i++;
		}
		return wTemp;
	}

	// Проверка выбран или нет элемент
	protected void CheckIsSelectedElement(final WebElement wElement,final Boolean bResult, String sName) throws ExceptFailTest
	{
		WebDriverWait wait = new WebDriverWait(driver, nTimeWait);
		try {
			wait.until(ExpectedConditions.elementSelectionStateToBe(wElement,
					bResult));
		} catch (TimeoutException exc) {
			String s = (bResult == true) ? " выделен " : " не выделен.";
			print("Элемент " + sName + s);
			throw new ExceptFailTest("Элемент " + sName + s);
		}
	}

	// получение числа из текста элементов (получение цены продукта)
	protected int GetIntFromTextInWebElement(WebElement wElement) throws ExceptFailTest
	{
		int nTemp;
		String sTemp;

		if ((sTemp = wElement.getText()).length() != 0) {
			sTemp = sTemp.replaceAll("[^0-9]", "");
		}

		try {
			nTemp = Integer.parseInt(sTemp);
		} catch (NumberFormatException exc) {
			throw new ExceptFailTest(
					"Не удалось перевести цену предложения в число");
		}

		return nTemp;
	}

	// проверка существует ли элемент (поиск по xpath)
	protected boolean CheckElement(final String sLocator, String sName)
	{
		WebElement wElement = null;
		WebDriverWait wWaitDriver = new WebDriverWait(driver, 2);
		try
		{
			wElement = wWaitDriver.until(new ExpectedCondition<WebElement>()
					{
				public WebElement apply(WebDriver wd)
				{
					return wd.findElement(By.xpath(sLocator));
				}
					}
										);
		}
		catch (TimeoutException exc)
		{
			System.out.println("Элемент " + sName + " не найден");
		}
		if (wElement == null)
			return false;
		else
			return true;
	}

	// Метод вывода в консоль
	public <T> void print(T obj)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(obj);
	}

	// Метод остановки процесса
	public void Sleep(int i) 
	{
		try 
		{
			Thread.sleep(i);
		}
		catch (InterruptedException exc) 
		{
			exc.printStackTrace();
		}
	}

	// Рандомное число
	protected int GetRandomNumber(int nLimit)
	{
		Random r = new Random();
		return r.nextInt(nLimit);
	}
}
