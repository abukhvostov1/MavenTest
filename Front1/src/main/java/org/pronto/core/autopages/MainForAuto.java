/**
 * 
 */
package org.pronto.core.autopages;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pronto.core.exception.FailTestException;
import org.pronto.core.pages.AbstractPage;

/**
 * @author abukhvostov
 * 
 */
public class MainForAuto extends AbstractPage {

	public MainForAuto(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Will open page " + url);
	}

	/**
	 * for the future need to made one function with parameter!
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public WebElement getPriceFrom() throws FailTestException {
		WebElement[] prices = getAllWebElements("//input[@name='price[from]']");
		if (prices.length == 0) {
			return null;
		} else {
			// Need to check convertion
			return prices[0];
		}
	}

	/**
	 * for the future need to made one function with parameter!
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public WebElement getYearFrom() throws FailTestException {
		WebElement[] years = getAllWebElements("//input[@name='car-year[from]']");
		if (years.length == 0) {
			return null;
		} else {
			return years[0];
		}
	}

	/**
	 * for the future need to made one function with parameter!
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public WebElement getYearTo() throws FailTestException {
		WebElement[] years = getAllWebElements("//input[@name='car-year[to]']");
		if (years.length == 0) {
			return null;
		} else {
			// need to check year for 4 cyfers!!!!
			return years[0];
		}
	}

	/**
	 * for the future need to made one function with parameter!
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public WebElement getPriceTo() throws FailTestException {
		WebElement[] prices = getAllWebElements("//input[@name='price[to]']");
		if (prices.length == 0) {
			return null;
		} else {
			return prices[0];
		}
	}

	/**
	 * Need to check
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public void checkCars(Collection<String> cars) throws FailTestException {
		WebElement[] allCars = getAllWebElements("//input[@type='checkbox'&&@name='make[]']");
		for (int i = 0; i < allCars.length; i++) {
			for (Iterator<String> iterator = cars.iterator(); iterator
					.hasNext();) {
				String car = (String) iterator.next();
				if (car.equals(allCars[i].getText())) {
					allCars[i].click();
				}
			}
		}

	}

	/**
	 * Need to check
	 * 
	 * @return
	 * @throws FailTestException
	 */
	public void checkBodyType(Collection<String> bodyTypes)
			throws FailTestException {
		WebElement[] allBodytypes = getAllWebElements("//input[@type='checkbox'&&@name='bodytype[]']");
		for (int i = 0; i < allBodytypes.length; i++) {
			for (Iterator<String> iterator = bodyTypes.iterator(); iterator
					.hasNext();) {
				String bodytype = (String) iterator.next();
				if (bodytype.equals(allBodytypes[i].getText())) {
					allBodytypes[i].click();
				}
			}
		}

	}
	
	public SearchResultPage click(WebElement webElement){
		clickElement(webElement);
		return PageFactory.initElements(driver, SearchResultPage.class);
	}
}
