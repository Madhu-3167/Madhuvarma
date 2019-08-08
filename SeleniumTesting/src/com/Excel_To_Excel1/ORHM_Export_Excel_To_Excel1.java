package com.Excel_To_Excel1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ORHM_Export_Excel_To_Excel1 {

	public static void main(String[] args) throws IOException {
      WebDriver driver=null;
      String url="https://opensource-demo.orangehrmlive.com/";
      System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
      driver=new ChromeDriver();
      driver.get(url);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
      XSSFWorkbook workbook=new XSSFWorkbook(file);
      XSSFSheet sheet=workbook.getSheet("sheet2");
      Row row=sheet.getRow(1);
      driver.findElement(By.id("txtUsername")).sendKeys(row.getCell(0).getStringCellValue());
      driver.findElement(By.id("txtPassword")).sendKeys(row.getCell(1).getStringCellValue());
      driver.findElement(By.id("btnLogin")).click();
      
      String expected="Welcome";
      System.out.println("The Homepage Title is:"+expected);
      WebElement Welcome_Title=driver.findElement(By.id("welcome"));
      String actual=Welcome_Title.getText();
      System.out.println("The Homepage title is :"+actual);
      
    if(actual.contains(expected))
    {
    	System.out.println("The Title Matched-PASS");
    	row.createCell(2).setCellValue("PASS");
    }
    else
    {
    	System.out.println("The Title Not Matched-FAIL");
    	row.createCell(2).setCellValue("FAIL");
    }
    FileOutputStream file1=new FileOutputStream("./src/com/Excel_Operations/Madhu.xlsx");
    workbook.write(file1);
    
	}

}
