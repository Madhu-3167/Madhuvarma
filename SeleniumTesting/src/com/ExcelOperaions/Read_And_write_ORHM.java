package com.ExcelOperaions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_And_write_ORHM {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet("sheet2");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);
		cell.setCellValue("UserName");
		Cell cell1=row.createCell(1);
		cell1.setCellValue("Password");
		Cell cell2=row.createCell(2);
		cell2.setCellValue("Result");
		Row row1=sheet.createRow(1);
		Cell cell3=row1.createCell(0);
		cell3.setCellValue("Admin");
		Cell cell4=row1.createCell(1);
		cell4.setCellValue("admin123");
		FileOutputStream file1=new FileOutputStream("./src/com/Excel_Operations/Madhu.xlsx");
		book.write(file1);
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		FileInputStream file2=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		   XSSFWorkbook book1=new XSSFWorkbook(file2);
		   XSSFSheet sheet1=book1.getSheet("Sheet2");
		   Row row2=sheet1.getRow(1);
		   Cell cell5=row2.getCell(0);
		   String Name=cell5.getStringCellValue();
		   System.out.println(Name);
		   Cell cell6=row2.getCell(1);
		   String pass=cell6.getStringCellValue();
		   System.out.println(pass);
		
		driver.findElement(By.id("txtUsername")).sendKeys(Name);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		
		String expected="Welcome";
		System.out.println("The expected login title is:"+expected);
		WebElement actual_Res=driver.findElement(By.id("welcome"));
		String actual=actual_Res.getText();
		System.out.println("The actual login title is:"+actual);
		Cell cell7=row1.createCell(2);
	    if(actual.contains(expected))
	    {
	    	System.out.println("Title Matched-PASS");
	    	cell7.setCellValue("PASS");
	    }
	    else
	    {
	    	System.out.println("Title Not Matched-FAIL");
	    	cell7.setCellValue("FAIL");
	    }
	    FileOutputStream file5=new FileOutputStream("./src/com/Excel_Operations/Madhu.xlsx");
    	book.write(file5);
	      
			/*Row row7=sheet2.createRow(1);
	    	Cell cell7=row7.createCell(2);
	    	cell7.setCellValue("PASS");
	    	FileOutputStream file5=new FileOutputStream("./src/com/XLsheet/Selenium.xlsx");
	    	book.write(file5);
	      }
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();*/
		
	}

}
