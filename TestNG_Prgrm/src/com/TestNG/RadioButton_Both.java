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

public class RadioButton_Both 
{
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
	public void RadioButton_Group1() throws InterruptedException 
	{
		WebElement	Table=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table"
				+ "/tbody"+ "/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));

		List<WebElement> RadioButtons1=Table.findElements(By.name("group1"));
		int Group1Count=RadioButtons1.size();
		System.out.println("Group1Count:"+Group1Count);

		List<WebElement> RadioButtons2=Table.findElements(By.name("group2"));
		int Group2Count=RadioButtons2.size();
		System.out.println("Group2Count:"+Group2Count);

		for(int i=1;i<=3; i++)
		{
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@name='group1']["+i+"]")).click();
			driver.findElement(By.xpath("//input[@name='group2']["+i+"]")).click();
			for(int k=0;k<Group2Count;k++)
			{
				System.out.println(RadioButtons1.get(k).getAttribute("value")+" "+RadioButtons1.get(k).getAttribute("checked"));
				System.out.println(RadioButtons2.get(k).getAttribute("value")+" "+RadioButtons2.get(k).getAttribute("checked"));
			}
		}
	}
	@AfterTest
	public void tearDown()
	{
		//driver.close();
	}
}
