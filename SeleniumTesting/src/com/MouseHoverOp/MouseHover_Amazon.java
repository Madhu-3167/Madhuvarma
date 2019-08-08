package com.MouseHoverOp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover_Amazon {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement HelloSignIn=driver.findElement(By.id("nav-link-accountList"));
		String HelloSignInText=HelloSignIn.getText();	
		System.out.println("The HelloSignIn text is:"+HelloSignInText);
		Actions act=new Actions(driver);
		act.moveToElement(HelloSignIn).perform();
		driver.findElement(By.linkText("Your Prime Video")).click();

	}

}
