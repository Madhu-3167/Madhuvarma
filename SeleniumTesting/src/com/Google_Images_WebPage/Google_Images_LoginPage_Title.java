package com.Google_Images_WebPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Images_LoginPage_Title {

	public static void main(String[] args) {
			String url="http://google.com";
			WebDriver driver=null;
			System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			//<a class="gb_d" data-pid="2" href="https://www.google.co.in/imghp?hl=en&amp;tab=wi&amp;ogbl">Images</a>
			WebElement Images=driver.findElement(By.linkText("Images"));
			Images.click();
			driver.getTitle();
			{
				System.out.println("The title of the Google Images Page is:"+driver.getTitle());
				
			}
			
	}

}
