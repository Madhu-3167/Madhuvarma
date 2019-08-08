package com.All_Links_Count;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_All_Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String url="https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCount=links.size();
			System.out.println("The links count in the Amazon Homepage is :"+linkCount);
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
			driver.navigate().back();
			links=driver.findElements(By.tagName("a"));
	     }
	}

}
	}
}
