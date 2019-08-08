package com.FacebookLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAppLogin {

	public static void main(String[] args) throws Throwable {
		String url="http:\\facebook.com";
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\WebAppTesting\\driverFiles\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys("krishnavamsis143");
		driver.findElement(By.id("pass")).sendKeys("9701620482");
		Thread.sleep(5000);
		driver.findElement(By.id("loginbutton")).click();
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCount=links.size();
		
		{
			
			System.out.println("The links count in the Facebook home page is :"+linkCount);
			
		}
		for(int i=0;i<linkCount;i++)
		{
			if(links.get(i).isDisplayed())
			{
			String linkName=links.get(i).getText();
			System.out.println(linkName);
			}
			
		}
	}
}
