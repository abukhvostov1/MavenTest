/**
 * 
 */
package org.pronto.core.listener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * This as variant of web driver listener
 * 
 * Without comments. I don't know how it works....
 * 
 * That's joke :-) 
 * Ask Dmitri
 *  
 * @author dsobol & abukhvostov
 *
 */
public class ListenerThatHiglilightsElements extends
		AbstractWebDriverEventListener {
	private long interval;
	private final int count;
	private final String color;

	/**
	 * Set default parameters by parent
	 * 
	 * @param count
	 * @param interval
	 * @param unit
	 */
	public ListenerThatHiglilightsElements(int count, long interval,
			TimeUnit unit) {
		this("#FFFF00", count, interval, unit);
	}

	/**
	 * Set needed highlight (do not say anybody) :-)
	 * 
	 * @param color
	 * @param count
	 * @param interval
	 * @param unit
	 */
	public ListenerThatHiglilightsElements(String color, int count,
			long interval, TimeUnit unit) {
		this.color = color;
		this.count = count;
		this.interval = TimeUnit.MILLISECONDS.convert(Math.max(0, interval),
				unit);
	}

	/**
	 * no comment
	 */
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		flash2(element, driver);
	}

	/**
	 * no comment
	 */
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		flash(by, driver);
	}

	/**
	 * no comment
	 */
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
	}

	/**
	 * no comment
	 */
	public void onException(Throwable throwable, WebDriver driver) {
	}

	/**
	 * Also as below but element should be found :-)
	 *  
	 * @param by
	 * @param driver
	 */
	private void flash(By by, WebDriver driver) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++) {
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}

	/**
	 * Just flash by element
	 * 
	 * @param element
	 * @param driver
	 */
	private void flash2(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < count; i++) {
			changeColor(color, element, js);
			changeColor(bgcolor, element, js);
		}
	}

	/**
	 * For changing highlighting
	 *  
	 * @param color
	 * @param element
	 * @param js
	 */
	private void changeColor(String color, WebElement element,
			JavascriptExecutor js) {
		js.executeScript(
				"arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(interval);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}
 }
