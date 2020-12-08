package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class LoginPage extends CommonUtil {

	String no="7080212697";
	
	@FindBy(xpath="//div[@class='signin ml-4']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div//img[@title='Choose Language']")
	private WebElement setLanguage;
	//input[@id='phoneno']
	@FindBy(xpath="//input[@id='phoneno']")
	private WebElement phoneNo;

	@FindBy(xpath="//div[@class=\"loginCta mt-4\"]//button")
	private WebElement sendOTPButton;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement fillCode;
	
	@FindBy(xpath="//button[@class='red button']")
	private WebElement continueButton;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@Step("Click Login Icon")
	public void clickLoginButton() {
		logger.info("Just Clicked Login Icon");
		pollWaitForElement(20, loginButton);
		loginButton.click();
	}
//	@Step("Input the Mobile No")
	public void inputMobileNo() {
		logger.info("Entering the Mobile No");
		pollWaitForElement(20, phoneNo);
		 phoneNo.sendKeys(no);
	}
	//@Step("Input the Mobile No")
	public void clickSendOTPButton() {
		logger.info("Clicking on send OTP");
		pollWaitForElement(20, sendOTPButton);
		sendOTPButton.click();
	}
	public void fillOTP(String OTP)
	{
		logger.info("Filling the OTP");
		pollWaitForElement(20,fillCode);
		fillCode.sendKeys(OTP);
	}
	public void loginStatus()
	{
		logger.info("Logging in");
		pollWaitForElement(20,continueButton);
		continueButton.click();
		System.out.println("You are logged in as "+no);
	}
	}
	
