package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Capture_AllRowsAndFirstColumn {
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
    	 
    	 ///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
    	 ///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
    	 
         /*
           for(int i=1;i<=36;i++)
          
         {
        	 WebElement CityNameElement=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td[1]"));
        	 String CityName=CityNameElement.getText();
             System.out.println(CityName);
         }
    	 */
    	 String part1="/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
    	 String part2="]/td[1]";
    	 for(int i=1;i<=36;i++)
    	 {
    		 String CityName=driver.findElement(By.xpath(part1+i+part2)).getText();
    		 System.out.println(CityName);
    	 }
     }
     @AfterTest
     public void tearDown()
     {
    	 driver.close();
     }
}
