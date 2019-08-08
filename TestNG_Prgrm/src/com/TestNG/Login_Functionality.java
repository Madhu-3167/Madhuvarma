package com.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Functionality {
 WebDriver driver=null;
 @BeforeTest
 public void LaunchApplication() 
 {
    String url="https://opensource-demo.orangehrmlive.com/";
	System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();	
}
  @Test(priority=1)
  public void LoginApplication() throws IOException
  {
	  FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
      XSSFWorkbook workbook=new XSSFWorkbook(file);
      XSSFSheet sheet=workbook.getSheet("sheet2");
      Row row=sheet.getRow(1);
	  driver.findElement(By.id("txtUsername")).sendKeys(row.getCell(0).getStringCellValue());
      driver.findElement(By.id("txtPassword")).sendKeys(row.getCell(1).getStringCellValue());
      driver.findElement(By.id("btnLogin")).click();
      String expected_OrhmTitle="Welcome";
		System.out.println("The title of the OhrmTitle is:"+expected_OrhmTitle);
		WebElement actual_OhrmTitle=driver.findElement(By.linkText("Welcome Admin"));
		String WelcomeText=actual_OhrmTitle.getText();
		System.out.println("The title of OhrmTitle is: "+WelcomeText);
		if(WelcomeText.contains(expected_OrhmTitle))
		{
			System.out.println("The title Matched-PASS");
			row.createCell(2).setCellValue("PASS");
		}
		else
		{
			System.out.println("The title not Matched-FAIL");
			row.createCell(2).setCellValue("FAIL");
		}
		FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/Selenium.xlsx");
		workbook.write(file1);
  }
  @Test(priority=2)
  public void LogoutApplication() throws InterruptedException
  {
	  driver.findElement(By.linkText("Welcome Admin")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Logout")).click();
	  
  }
  @AfterTest
  public void Applicationclose()
  {
	  driver.close();
  }
  
}