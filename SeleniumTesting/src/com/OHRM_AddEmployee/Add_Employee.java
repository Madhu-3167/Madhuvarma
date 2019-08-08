package com.OHRM_AddEmployee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Add_Employee {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act=new Actions(driver);
		act.moveToElement(PIM).perform();
		driver.findElement(By.linkText("Employee List")).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\'search-results\']/div")));
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("Madhu");
		driver.findElement(By.id("lastName")).sendKeys("Varma");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
