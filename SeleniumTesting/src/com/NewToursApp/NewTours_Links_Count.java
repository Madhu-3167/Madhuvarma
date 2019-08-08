package com.NewToursApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Links_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		//<a href="mercurysignon.php?osCsid=a0bba59ec6ee7a697b9ee3f928eca531">SIGN-ON</a>
		//<a href="mercuryregister.php?osCsid=a0bba59ec6ee7a697b9ee3f928eca531">REGISTER</a>
		//<a href="mercuryunderconst.php?osCsid=a0bba59ec6ee7a697b9ee3f928eca531">SUPPORT</a>
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linksCount=links.size();
		{
			System.out.println("The links count in the NewTours home page is :"+linksCount);
			
		}
		for(int i=0;i<linksCount;i++)
		{
		String linkName=links.get(i).getText();
		System.out.println(linkName);
		}
		
	}

}
