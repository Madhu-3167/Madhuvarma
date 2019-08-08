package com.NewToursApp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_LoginWithTitle {

	public static void main(String[] args) {
		String url="http://www.newtours.demoaut.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		 String expected_NewToursTitleAfterLogin="Find a Flight: Mercury Tours:";
		 {
			 System.out.println("new tours Title after login is:"+expected_NewToursTitleAfterLogin);
		 }
		 String actual_NewToursTitleAfterLogin=driver.getTitle();
		 {
			 System.out.println("new tours Title after login is:"+actual_NewToursTitleAfterLogin);
		 }
		 if(actual_NewToursTitleAfterLogin.contains(expected_NewToursTitleAfterLogin))
		 {
			 System.out.println("The Title Matched-PASS");
		 }else
		 {
			 System.out.println("The Title Not matched-FAIL");
		 }
		 //driver.close();
			 
	}

}
