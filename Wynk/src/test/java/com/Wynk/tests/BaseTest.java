package com.Wynk.tests;

import java.net.MalformedURLException;
//import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Wynk.tests.pages.*;
import com.Wynk.tests.util.CommonUtil;
public class BaseTest extends CommonUtil{
	protected ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	@SuppressWarnings("resource")
	@Test
	public void preCondition() throws MalformedURLException, InterruptedException {
		PropertyConfigurator.configure("Log4j.properties");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--incognito");
System.setProperty("webdriver.chrome.driver","C:\\Users\\IQA\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		//Browser Initialize
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://wynk.in/music");;

		// Create object of pages
		LoginPage loginPage=new LoginPage(driver);
		RetroHitsPage retroHitPage=new RetroHitsPage(driver);
		TopAlbumsPage topAlbumsPage=new TopAlbumsPage(driver);
		TopChartsPage topChartsPage=new TopChartsPage(driver);
		PlayMusicPage playMusic=new PlayMusicPage(driver);
		CommonLocators commonLocators=new CommonLocators(driver);
		LogOutPage logOutPage=new LogOutPage();
		loginPage.clickLoginButton();
		logger.info("Enter your Mobile No");
		loginPage.inputMobileNo();
		loginPage.clickSendOTPButton();
		String OTP;
		System.out.println("Enter OTP");
		Scanner sc=new Scanner(System.in);
		OTP=sc.nextLine();
		loginPage.fillOTP(OTP);
		loginPage.loginStatus();

		System.out.println("Enter Song");
		String Song="";
		Scanner sc1=new Scanner(System.in);
		Song=sc.nextLine();
	    playMusic.inputText(Song);
	    topChartsPage.countMusicOptions(driver);
	    driver.navigate().back();
	    
	    commonLocators.playMusicButton();
	    logOutPage.logOut();
	    }
	@AfterSuite
	public void postcondition()
	{
		WebDriver driver=getDriver();
		if(driver!=null)
			driver.quit();
	}
}
