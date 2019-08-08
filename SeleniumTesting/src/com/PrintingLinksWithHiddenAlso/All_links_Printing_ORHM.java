package com.PrintingLinksWithHiddenAlso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_links_Printing_ORHM {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int linksCount=links.size();
		System.out.println("The total links of OHRM login page is:"+linksCount); 
		for(int i=0;i<linksCount;i++)
		{
			if(links.get(i).isDisplayed())
			{
				String linkName=links.get(i).getText();
			System.out.println("The links names is:"+linkName);
		    }
			
		}

	}

}
