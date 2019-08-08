package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureFirst_RowAnd_FirstColumn {
	 WebDriver driver=null;
     String url="https://www.timeanddate.com/worldclock/";
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
     @Test
     public void FirstRowFirstColumnCityName()
     {
    	 WebElement CityNameElement=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]"));
         String CityName=CityNameElement.getText();
         System.out.println(CityName);
     }
     @AfterTest
     public void tearDown()
     {
    	 driver.close();
     }

}
