package pack_page;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pack_utils.ExceptFailTest;

public class Page_IrrMain extends Page {

	@FindBy(xpath = "//div[@class='popupRegions']")
	private WebElement wWindowSelectOfRegion;

	@FindBy(xpath = "//div[@class='button-style btn-a']/a")
	private WebElement wOkButtonWindowSelectOfRegion;

	// поле поиска
	@FindBy(xpath = "//input[@id='id_keywords']")
	private WebElement wInputFieldSearch;

	// кнопка найти когда введен текст
	@FindBy(xpath = "//div[contains(@class,'wrSearch')]//a")
	private WebElement wButtonSearch;

	// список саджестов
	private WebElement wLinkSuggestText[];
	String sXpathSuggest = "//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']/li[@class='ui-menu-item']/a";
	// String sXpathSuggest =
	// "//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']/li[@class='ui-menu-item']/a[@class='ui-corner-all']";

	String sF; // слово по которому ищем здесь храним

	private JavascriptExecutor js;

	private ArrayList<String> suggestLinks = new ArrayList<String>();

	public Page_IrrMain(WebDriver driver) {
		super(driver);
	}

	public void OpenPage(String sUrl) {
		driver.navigate().to(sUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Открываем страницу " + sUrl);
	}

	public void CloseWindowRegion() throws ExceptFailTest {

		CheckElementPresent(1, "//div[@class='popupRegions']");
		if (wWindowSelectOfRegion.isDisplayed()) {
			print("Закрываем окно выбора регионов");
			CheckElementPresent(1, "//div[@class='button-style btn-a']/a");
			wOkButtonWindowSelectOfRegion.click();
		}
	}

	public Page_Search SendTextToFieldSearch(String sFindWord)
			throws ExceptFailTest {

		CheckElementPresent(1, "//input[@id='id_keywords']");
		print("\r\nВводим в поле поиска текст - " + sFindWord);
		SendText(wInputFieldSearch, sFindWord);
		Sleep(500);
		CheckElementPresent(1, "//div[contains(@class,'wrSearch')]//a");
		print("Нажимаем найти");
		ClickElement(wButtonSearch);
		Sleep(3000);
		return PageFactory.initElements(driver, Page_Search.class);
	}

	// получение саджестов
	public ArrayList<String> GetListSuggest(String sFindWord)
			throws ExceptFailTest {
		ArrayList<String> listTemp = new ArrayList<String>();
		sF = sFindWord;
		js = (JavascriptExecutor) driver;
		driver.get(driver.getCurrentUrl());
		CheckElementPresent(1, "//input[@id='id_keywords']");
		print(" ");
		print("Вводим в поле поиска текст - " + sFindWord);
		SendText(wInputFieldSearch, sFindWord);
		Sleep(1000);

		try {
			wLinkSuggestText = this.GetAllWebElements(sXpathSuggest);

		} catch (ExceptFailTest exc) {
			print("Нет ни одного саджеста для слова - " + sFindWord);
			throw new ExceptFailTest("Нет ни одного саджеста для слова - "
					+ sFindWord);
		}
		print("\r\nСписок названий саджестов получен");
		CaptureScreenshot("SuggestMain"); // скриншот саджестов

		for (int i = 0; i < wLinkSuggestText.length; i++) {
			listTemp.add(wLinkSuggestText[i].getText().toLowerCase());
			print(wLinkSuggestText[i].getText());
		}
		return listTemp;
	}

	// сравнение двух лист
	public void CompareSuggests(ArrayList<String> listOne,
			ArrayList<String> listSecond) throws ExceptFailTest {
		if (listOne.containsAll(listSecond))
			print("Списки саджестов одинаковы");
		else {
			print("Списки саджестов не одинаковы");
			throw new ExceptFailTest("Списки саджестов не одинаковы");
		}
	}

	// переход по саджесту
	public Page_Search GoToSuggest() throws ExceptFailTest {
		if (wLinkSuggestText.length == 0) {
			print("Нет ни одного саджеста для слова - " + sF);
			throw new ExceptFailTest("Нет ни одного саджеста для слова - " + sF);
		}
		print("\r\nПереходим по саджесту - " + wLinkSuggestText[0].getText());
		ClickElement(wLinkSuggestText[0]);
		return PageFactory.initElements(driver, Page_Search.class);
	}

	// Возвращает саджест линки
	public ArrayList<String> GetListLink(String sFindWord)
			throws ExceptFailTest {
		DefaultHttpClient client = new DefaultHttpClient();
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String response = "";

		HttpGet request = new HttpGet(
				"http://master.prontosoft.by/ajax/get_search_suggest.php?address_string=&keywords="
						+ sFindWord + "&_=1367823910799");
		try {
			response = client.execute(request, responseHandler);
			JSONObject jObj = new JSONObject(response.trim());
			JSONArray suggItems = jObj.getJSONArray("items");
			for (int i = 0; i < suggItems.length(); i++) {
				String temp = driver.getCurrentUrl().substring(0,
						driver.getCurrentUrl().length() - 1)
						+ URLDecoder.decode(
								((JSONObject) suggItems.get(i)).get("url")
										.toString(), "UTF-8").toLowerCase();
				System.out.println(temp);
				suggestLinks.add(temp);
			}
		} catch (Exception e) {
			throw new ExceptFailTest("Не возможно получить линки на саджесты");
		}
		return suggestLinks;
	}
}
