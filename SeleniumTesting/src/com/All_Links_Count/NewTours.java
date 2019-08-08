package com.All_Links_Count;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		//System.setProperty("webdriver.gecko.driver", "./driverFiles/geckodriver.exe");
		//WebDriver driver1=new FirefoxDriver();
		//driver1.navigate().to(url);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCount=links.size();
			System.out.println("The links count in the Newtours home page is :"+linkCount);
			{
		for(int i=0;i<linkCount;i++)
			{
	     if(links.get(i).isDisplayed())
	     {
			String linkName=links.get(i).getText();
			System.out.println(linkName);
			links.get(i).click();
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			Thread.sleep(3000);
			driver.navigate().back();
			links=driver.findElements(By.tagName("a"));
			
	}
	}
	}
	}
}
