package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class TopSearchedPage extends CommonUtil {
     public TopSearchedPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
}
