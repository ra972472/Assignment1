package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class RetroHitsPage extends CommonUtil
{
   public RetroHitsPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
 @FindBy(xpath="//div[@class=\"col-6 col-sm-3 col-md-2 col-lg-2 mb-4\"]")
 private WebElement countElements;
// public void countIcons()
// {
//	 logger.info("Total No Icons are counting");
//	 pollWaitForElement(20,countElements);
//	 countElements.
// }
}
