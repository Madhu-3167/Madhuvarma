package com.Xpath_Types;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reddiff_Xpath {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://register.rediff.com";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create Account")).click();
        //<input type="text" onblur="fieldTrack(this);" 
		//name="name6f0cf47b" value="" style="width:185px;" maxlength="61">
		//driver.findElement(By.xpath("//input[@name='name6f0cf47b']")).sendKeys("Madhuvarma");
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("madhuvarma");
	}
}
