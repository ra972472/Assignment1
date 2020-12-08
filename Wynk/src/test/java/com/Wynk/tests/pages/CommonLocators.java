package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class CommonLocators extends CommonUtil  {

	public CommonLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='icon-ic_global_play_dark position-absolute rounded-circle splay']")
	private WebElement firstChoice;
	
@FindBy(xpath="//button[@xpath='1']")
private WebElement playButton;

@FindBy(xpath="//div[@class='dark-mode-switch dark']")
private WebElement switchtoDarkMode;

@FindBy(xpath="//div[@class='circle']")
private WebElement switchtoLightMode;

@FindBy(xpath="//input[contains(@placeholder,'music you love!')]")
private WebElement searchMusic;

@FindBy(xpath="//li[@xpath='1']")
private WebElement signOutButton;
//@Step("Dark Mode is clicked")
public void changeToDarkMode() {
	pollWaitForElement(20, switchtoDarkMode);
	switchtoDarkMode.click();
}
@FindBy(xpath="//div[@class=\"d-flex justify-content-between align-items-center mb-3\"]")
private WebElement topHeadings;
public int countElement()
{
    logger.info("Counting Major Headings");
    String xpath="//div[@class=\\\"d-flex justify-content-between align-items-center mb-3\\\"]";
    return countNoOfElements(xpath);
    
}
//@Step("Dark Mode is clicked")
public void changeToLightMode() {
	pollWaitForElement(20, switchtoLightMode);
	switchtoLightMode.click();
}
public void playMusicButton()
{
	logger.info("Clicking the choice");
	mouseHover(firstChoice);
	pollWaitForElement(20,firstChoice);
	firstChoice.click();
	logger.info("Clicking on Play button");
	pollWaitForElement(20,playButton);
	playButton.click();
}
}
