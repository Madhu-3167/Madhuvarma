package com.NewTours.Pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NewTours.Pages.LogInPage;

public class LogInPageTest extends BaseTest1  {
	
	@Test
	public void LogInPageTesting() throws IOException
	{
		LogInPage LogIn=PageFactory.initElements(driver, LogInPage.class);

		LogIn.SignOn();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();

		LogIn.Register();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();

		LogIn.Support();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();

		LogIn.Contact();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.navigate().back();

		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		int rowCount=sheet.getLastRowNum();
		for(int i=0;i<rowCount;i++)
		{
			Row row=sheet.getRow(i);
			LogIn.Login(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());

			String expected_Title="Find";
			System.out.println("The expected Title is:"+expected_Title);
			String actual_title=driver.getTitle();
			System.out.println("The actual Title is:"+actual_title);

			if(actual_title.contains(expected_Title))			
			{
				System.out.println("LogIn Successfully-PASS");
				row.createCell(2).setCellValue("LogIn Successfully-PASS");
			}
			else
			{
				System.out.println("LogIn Failed-FAIL");
				row.createCell(2).setCellValue("LogIn Failed-FAIL");
			}
			FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/NewTours.xlsx");
			workbook.write(file1);
			driver.navigate().back();
		}		
	}
	
}
