package com.Ohrm_Logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Validation_Logout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String expected_OrhmTitle="Welcome";
		System.out.println("The title of the OhrmTitle is:"+expected_OrhmTitle);
		WebElement actual_OhrmTitle=driver.findElement(By.linkText("Welcome Admin"));
		String WelcomeText=actual_OhrmTitle.getText();
		System.out.println("The title of OhrmTitle is: "+WelcomeText);
		if(WelcomeText.contains(expected_OrhmTitle))
		{
			System.out.println("The title Matched-PASS");
		}
		else
		{
			System.out.println("The title not Matched-FAIL");
		}
		
		actual_OhrmTitle.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
	}

}
