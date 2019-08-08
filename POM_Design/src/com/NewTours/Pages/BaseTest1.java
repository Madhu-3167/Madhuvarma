package com.NewTours.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest1 {
	WebDriver driver=null;
	//String url="https://opensource-demo.orangehrmlive.com/";
	String url="http://www.newtours.demoaut.com/";
    @BeforeTest
    public void SetUp()
    {
   	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
   	 driver=new ChromeDriver();
   	 driver.get(url);
   	 driver.manage().window().maximize();
   	 driver.manage().deleteAllCookies();
   	 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown()
    {
   	 driver.close();
    }

}

