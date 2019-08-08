package com.HandlingAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_CheckAvailability_click {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://www.tsrtconline.in/oprs-web/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("searchBtn")).click();
		Alert alt=driver.switchTo().alert();
		String alert_text=alt.getText();
		System.out.println("The text of an alert is:"+alert_text);
        alt.accept();
        //alt.dismiss();
        
		

	}

}
