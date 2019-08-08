package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureAll_RowsAndColumns {
	WebDriver driver=null;
    String url="https://www.timeanddate.com/worldclock/";
    @BeforeTest
    public void SetUp() throws InterruptedException
    {
   	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
   	 driver=new ChromeDriver();
   	 Thread.sleep(3000);
   	 driver.get(url);
   	 driver.manage().window().maximize();
   	 driver.manage().deleteAllCookies();
   	 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void AllRowsAndAllColumnsCityName()
    {
   	 
   	 ///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
     ///html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
   	 for(int i=1;i<=36;i++)
   	 {
   		 for(int k=1;k<=8;k++)
   		 {
   			WebElement CityName=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+k+"]")); 
   		    System.out.print(CityName.getText()+"  ");
   		 }
   		 System.out.println();
   	 }
    }
    @AfterTest
    public void tearDown()
    {
   	 driver.close();
    }

}
