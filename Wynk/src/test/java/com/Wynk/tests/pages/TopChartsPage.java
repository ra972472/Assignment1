package com.Wynk.tests.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class TopChartsPage extends CommonUtil {
	public TopChartsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[@href=\"/music/list/top-charts/bsb_charts\"]")
private WebElement topCharts;
public void move()
{
	logger.info("Moving to Top Charts Page");
	pollWaitForElement(20,topCharts);
	
}
public void countMusicOptions(WebDriver driver)
{
	List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"col-6 col-sm-3 col-md-2 col-lg-2 mb-4\"]"));
	System.out.println("No of Icon with play Sign are "+list.size());
}
}
