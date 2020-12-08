package com.Wynk.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Wynk.tests.util.CommonUtil;

public class TopAlbumsPage extends CommonUtil {
   public TopAlbumsPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);;
   }
}
