package com.TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButton_Group1 {

	WebDriver driver=null;
	String url="http://www.echoecho.com/htmlforms10.htm";
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
    	public void RadioButton_Group1() 
    	{
    WebElement	Table=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
    List<WebElement> RadioButtons=Table.findElements(By.name("group1"));
    int RadioButtonsCount=RadioButtons.size();
     for(int i=0;i<RadioButtonsCount;i++)
     {
    	//String Name=RadioButtons.get(i).getAttribute("value");
    	//System.out.println(Name);
    	RadioButtons.get(i).click();
    for(int k=0;k<RadioButtonsCount;k++)
    {
    	System.out.println(RadioButtons.get(k).getAttribute("value")+" "+RadioButtons.get(k).getAttribute("checked"));
    	
    }
     }
    	}
    @AfterTest
    public void tearDown()
    {
   	 //driver.close();
    }
}
