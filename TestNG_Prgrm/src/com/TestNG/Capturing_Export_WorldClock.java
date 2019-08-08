package com.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Capturing_Export_WorldClock extends BaseTest{
	@Test
    public void WorldClock_Export() throws IOException, InterruptedException
    {
		FileInputStream file=new FileInputStream("./src/com/Excel_Result/Selenium.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet4");
	   	WebElement Rows=driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody")); 
	   	List<WebElement> RowsTable=Rows.findElements(By.tagName("tr"));
	   	int RowsCount=RowsTable.size();
	   	for(int i=0;i<=RowsCount;i++)
	   	{
	    List<WebElement> ColumnsTable = RowsTable.get(i).findElements(By.tagName("td"));  
        int columnsCount=ColumnsTable.size();
        Row row=sheet.createRow(i);
        for (int j=0; j<columnsCount; j++) 
        {
    	String cellName = ColumnsTable.get(j).getText();
    	System.out.print(cellName+" ");
	    Cell cell=row.createCell(j);
	   	cell.setCellValue(cellName);
	    FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/Selenium.xlsx");
	    workbook.write(file1);
	   		 }
	   		 System.out.println();
	   	 }
		
    }
    }
	

