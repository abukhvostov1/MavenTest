/**
 * 
 */
package org.pronto.test;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.pronto.core.autopages.MainForAuto;
import org.pronto.core.autopages.SearchResultPage;
import org.pronto.core.exception.FailTestException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author abukhvostov
 * 
 */
public class TestAuto1 extends TestConstruct {

	MainForAuto autoFilterPage = PageFactory.initElements(driver[0],
			MainForAuto.class);

	@FindBy(xpath = "//a[@id='show-result-search]'")
	WebElement button;

	@BeforeTest
	public void TestBefore() throws FailTestException {
		print("Start @BeforeTest");
		print("End @BeforeTest");
	}

	@AfterTest
	public void TestAfter() {
		print("Start @AfterTest");
		print("End @AfterTest");
	}

	@Test(invocationCount = 1)
	@Parameters( { "sUrl", "sLogin", "sPassword", "priceFrom", "priceTo",
			"yearFrom", "yearTo", "mark", "bodytype" })
	public void TestStart(String sUrl, String sLogin, String sPassword,
			String priceFrom, String priceTo, String yearFrom, String yearTo,
			ArrayList<String> mark, ArrayList<String> bodytype)
			throws FailTestException {
		print("Start @Test");
		autoFilterPage.openPage(sUrl);
		autoFilterPage.sendText(autoFilterPage.getPriceFrom(), "" + priceFrom);
		autoFilterPage.sendText(autoFilterPage.getPriceTo(), "" + priceTo);
		autoFilterPage.sendText(autoFilterPage.getYearFrom(), "" + yearFrom);
		autoFilterPage.sendText(autoFilterPage.getYearTo(), "" + yearTo);
		autoFilterPage.checkCars(mark);
		autoFilterPage.checkBodyType(bodytype);
		SearchResultPage searchResultPage = autoFilterPage.click(button);
		print("End @Test");
	}

}
