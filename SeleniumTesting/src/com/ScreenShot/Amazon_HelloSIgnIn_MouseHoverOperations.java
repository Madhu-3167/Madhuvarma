package com.ScreenShot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Amazon_HelloSIgnIn_MouseHoverOperations {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement HelloSignIn=driver.findElement(By.id("nav-link-accountList"));
		Actions act=new Actions(driver);
		act.moveToElement(HelloSignIn).perform();
		driver.findElement(By.linkText("Your Seller Account")).click();
		

	}

}
