package com.HeaderBlockCount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_HeaderBlock_Count {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://www.tsrtconline.in/oprs-web/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
	    driver.manage().window().maximize();
	   WebElement HeaderBlock=driver.findElement(By.className("menu-wrap"));
	   List<WebElement>HeaderBlockLinks=HeaderBlock.findElements(By.tagName("a"));
	  int HeaderBlockLinksCount =HeaderBlockLinks.size();
	  System.out.println("The Links in the HeaderBlock of TSRTC home page are:"+HeaderBlockLinksCount);
	  for(int i=0;i<HeaderBlockLinksCount;i++)
	  {
		  String HeaderBlockLinkName =HeaderBlockLinks.get(i).getText();
		  System.out.println(i+" "+HeaderBlockLinkName);
	  }	  
	}
}
	
