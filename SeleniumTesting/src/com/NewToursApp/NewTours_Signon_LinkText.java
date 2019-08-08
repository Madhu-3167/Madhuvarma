package com.NewToursApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Signon_LinkText {

	public static void main(String[] args) {
		String url="http://www.newtours.demoaut.com/";
		WebDriver driver=null;
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		//<a href="mercurysignon.php?osCsid=82ffac5d37b95b9cefb0eead8eb486a8">SIGN-ON</a>
		WebElement Signon=driver.findElement(By.linkText("SIGN-ON"));
		Signon.click();
	}

}

