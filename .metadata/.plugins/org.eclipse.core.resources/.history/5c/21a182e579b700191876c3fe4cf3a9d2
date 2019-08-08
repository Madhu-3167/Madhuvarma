package com.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
             
	WebDriver driver=null;
    String url="https://opensource-demo.orangehrmlive.com/";
   @BeforeTest
   public void SetUp() throws InterruptedException
   {
 	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 //driver.manage().deleteAllCookies();
	 //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(4000);
   }
	@Test
	public void LogIn() throws IOException
	   {
	   	FileInputStream file=new FileInputStream("./src/com/Configuration/OHRM.properties");
	   	Properties prop=new Properties();
	   	prop.load(file);
	   	driver.findElement(By.name(prop.getProperty("uName"))).sendKeys(prop.getProperty("UserName"));
	   	//UserName.sendKeys(prop.getProperty("UserName"));
	    driver.findElement(By.name(prop.getProperty("pwd"))).sendKeys(prop.getProperty("Passowrd"));
	   	//password.sendKeys(prop.getProperty("Password"));
	    driver.findElement(By.name(prop.getProperty("SignIn"))).click();
	    
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
		
	   }
	
@AfterTest
public void tearDown()
{
	 driver.close();
}
}
