package com.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_EmpData_Export {

	WebDriver driver=null;
	String url="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    @BeforeTest
    public void SetUp() throws Exception
    {
   	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
   	 driver=new ChromeDriver();
   	 driver.get(url);
   	 driver.manage().window().maximize();
   	 //driver.manage().deleteAllCookies();
   	 //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
   	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	 Thread.sleep(2000);
    }
    @Test
    public void OHRM_EmpDataExport() throws Exception
    {
    	FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
    	XSSFWorkbook workbook=new XSSFWorkbook(file);
    	XSSFSheet sheet=workbook.getSheet("Sheet2");
    	driver.findElement(By.id("txtUsername")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
        driver.findElement(By.id("txtPassword")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(3000);
    	   WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
   	       Actions act=new Actions(driver);
   	       act.moveToElement(PIM).perform();
   	       driver.findElement(By.id("menu_pim_viewEmployeeList")).click();   
   	   WebElement Table=driver.findElement(By.xpath("//*[@id=\'resultTable\']/tbody"));
   	   List<WebElement> RowsTable=Table.findElements(By.tagName("tr"));
   	   int RowsCount=RowsTable.size();
     	for(int i=0;i<RowsCount;i++)
   	{
       List<WebElement> ColumnsTable = RowsTable.get(i).findElements(By.tagName("td"));  
       int columnsCount=ColumnsTable.size();
       Row row1=sheet.createRow(i);
    for (int j=0; j<columnsCount; j++) 
    {
	String cellName = ColumnsTable.get(j).getText();
	System.out.print(cellName+" ");
    Cell cell=row1.createCell(j);
   	cell.setCellValue(cellName);
    FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/OHRM_Export.xlsx");
    workbook.write(file1);
   	   } 
    System.out.println();
   	}
    }
    @AfterTest
    public void tearDown()
    {
   	 //driver.close();
   }
}
