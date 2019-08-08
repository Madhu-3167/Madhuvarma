package com.GetAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Register_GetAttribute {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ref_url=driver.findElement(By.linkText("REGISTER")).getAttribute("href");
		System.out.println("The register url is:"+ref_url);
		String Name_Property=driver.findElement(By.name("userName")).getAttribute("name");
		System.out.println(Name_Property);
		
		

	}

}
