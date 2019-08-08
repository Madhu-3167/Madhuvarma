package com.OHRM.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInKeyWords 
{
	WebDriver driver=null;
	
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
	}
    public void navigate()
    {
    	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
    public void enterUsername()
    {
    	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    }
    public void enterPassword()
    {
    	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    }
    public void ClickLogin()
    {
    	driver.findElement(By.id("btnLogin")).click();
    }
}
