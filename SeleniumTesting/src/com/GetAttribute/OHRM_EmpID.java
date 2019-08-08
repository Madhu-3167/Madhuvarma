package com.GetAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_EmpID {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act=new Actions(driver);
		act.moveToElement(PIM).perform();
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("Madhu");
		driver.findElement(By.id("lastName")).sendKeys("Varma");
	   
		WebElement expected=driver.findElement(By.id("employeeId"));
		String expected_OrhmTitle=expected.getAttribute("value");
		System.out.println("The title of the expected_OrhmTitle is:"+expected_OrhmTitle);
		
		driver.findElement(By.id("btnSave")).click();
		
		WebElement actual_OhrmTitle=driver.findElement(By.id("personal_txtEmployeeId"));
		String WelcomeText=actual_OhrmTitle.getAttribute("value");
		System.out.println("The title of actual_OhrmTitle is: "+WelcomeText);
		
		if(WelcomeText.contains(expected_OrhmTitle))
		{
			System.out.println("The title Matched-PASS");
		}
		else
		{
			System.out.println("The title not Matched-FAIL");
		}
		Thread.sleep(4000);
		WebElement admin=driver.findElement(By.id("welcome"));
		admin.click();
		driver.findElement(By.linkText("Logout")).click();

	}

}
