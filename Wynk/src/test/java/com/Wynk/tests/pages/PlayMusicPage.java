package com.Wynk.tests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class PlayMusicPage extends CommonUtil
{
	public PlayMusicPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[contains(@placeholder,'music you love!')]")
private WebElement searchMusic;
@FindBy(xpath="//div[@class=\"searchBtn position-absolute\"]")
private WebElement songSearch;
public void inputText(String Song) 
{
	logger.info(Song+" is playing");
	pollWaitForElement(20,searchMusic);
	searchMusic.sendKeys(Song);;
	logger.info("Enter is clicked");
	pollWaitForElement(20,searchMusic);
	searchMusic.sendKeys(Keys.ENTER);
}
}
