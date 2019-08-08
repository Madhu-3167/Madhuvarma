package com.Drop_Down;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New_Tours {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet3");
		
	 WebDriver driver=null;
	 String url="http://www.newtours.demoaut.com/";
	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("REGISTER")).click();
	 WebElement country=driver.findElement(By.name("country"));
	List<WebElement> countries=country.findElements(By.tagName("option"));
	int countriesCount=countries.size();
	{
		System.out.println("The countries count is:"+countriesCount);
	}
	 for(int i=0;i<countriesCount;i++)
	 {
		 String CountryName=countries.get(i).getText();
		 System.out.println(i+" "+CountryName);
		 
		 Row row =sheet.createRow(i);
		 Cell cell=row.createCell(0);
		 cell.setCellValue(CountryName);
		 FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/Selenium.xlsx");
		 workbook.write(file1);
		 
	 }
	 System.out.println();
	 
	}
	}

