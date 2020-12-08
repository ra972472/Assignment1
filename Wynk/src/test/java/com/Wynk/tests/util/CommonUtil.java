package com.Wynk.tests.util;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonUtil {
	protected WebDriver driver;
	public static Logger logger = Logger.getLogger("Pages");
	public static Properties properties;
	public static Date date;
	public static SimpleDateFormat simpleDateFormat;
//	static String propertyValue = null;
//	private static File jsonfile;
//	WebElement elementFound = null;
//	Actions action = null;

	public void mouseHover(WebElement element) {
		logger.info("Move to element " + element.toString());
		new Actions(driver).moveToElement(element).build().perform();
	}

	public void mouseHoverAndClick(WebElement element) {
		logger.info("Move to element " + element.toString());
		new Actions(driver).moveToElement(element).click().build().perform();
	}
    public int countNoOfElements(String xpath)
    {
    	List<WebElement> optionCount = driver.findElements(By.xpath(xpath));
    	System.out.println(optionCount.size());
    	return (optionCount.size());
    	
    }
	public boolean pollWaitForElement(int time, WebElement webElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		logger.info("Looking for element " + webElement.toString());
		int flag = 0;
		for (int i = 0; i < time; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			if (webElement.isEnabled() && webElement.isDisplayed()) {
				logger.info("Element found " + webElement.toString());
				flag = 1;
				break;
			} else {
				flag = -1;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}

		
	public void hardSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean pollWaitForXpath(int time,  String xpathExpression) {
		List<WebElement> elementList = null;
		Wait<WebDriver> customWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(time)).ignoring(NoSuchElementException.class);

		elementList = (List<WebElement>) customWait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				if (driver.findElements(org.openqa.selenium.By.xpath(xpathExpression)).size() == 0) {
					return null;
				} else {
					logger.info(xpathExpression + " found");
					return driver.findElements(org.openqa.selenium.By.xpath(xpathExpression));
				}

			}
		});

		if (elementList.size() == 0) {
			logger.info(xpathExpression + "not found");
			return false;
		} else {
			return true;
		}
	}

	public WebElement getXpathWebElement(int n, String xpathExpression) {
		return pollWaitForXpath(n, xpathExpression) ? driver.findElement(By.xpath(xpathExpression)) : null;
	}

	public void jse(String script) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript(script);
		logger.info("Executed JavaScript " + script);
	}

	public void jse(String script, WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript(script);
		logger.info("Executed JavaScript " + script);
	}

	public boolean verifyText(int t, WebElement WebElement, String expectedString) {
		pollWaitForElement(t, WebElement);
		String actualText = String.valueOf(WebElement.getText().trim());
		String expectedText = String.valueOf(expectedString);
		if (actualText.trim().equalsIgnoreCase(expectedText.trim())) {
			logger.info("Actual text (" + actualText + ") is matching with the expected text (" + expectedText + ")");
			return true;
		} else {
			logger.info(
					"Actual text (" + actualText + ") is not matching with the expected text (" + expectedText + ")");
			return false;
		}
	}

	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		logger.info("Page title is " + pageTitle);
		return pageTitle;
	}

	public void switchToWindow(String windowHandle) {
		logger.info("Switch to window " + windowHandle.toString());
		driver.switchTo().window(windowHandle);
	}

	public void switchToIframe(String iframe) {
		logger.info("Switch to iframe " + iframe.toString());
		driver.switchTo().frame(iframe);
	}

//	public boolean containsIgnoreCase(String sourceStr, String searchStr) {
//		return StringUtils.containsIgnoreCase(sourceStr, searchStr);
//	}

	public void scroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
