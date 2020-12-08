 package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class LogOutPage extends CommonUtil {
	public void LogOut(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@alt=\"Profile\"]")
	private WebElement profileIconButton;
    @FindBy(xpath="class=\"text-light\"")
    private WebElement signOut;
    
    public void logOut() {
    	logger.info("Sign out");
    	pollWaitForElement(20,profileIconButton);
    	profileIconButton.click();
    	pollWaitForElement(20,signOut);
    	signOut.click();
    }
}
