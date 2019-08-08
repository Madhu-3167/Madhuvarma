package com.Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Hybrid {

	WebDriver driver=null;
    String url="https://opensource-demo.orangehrmlive.com/";
   @BeforeTest
   public void SetUp() throws InterruptedException
   {
 	 System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 //driver.manage().deleteAllCookies();
	 //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(4000);
   }
	@Test(priority=1)
	public void LogIn() throws IOException
	   {
	   	FileInputStream file=new FileInputStream("./src/com/Configuration/OHRM.properties");
	   	Properties prop=new Properties();
	   	prop.load(file);
	   	driver.findElement(By.name(prop.getProperty("uName"))).sendKeys(prop.getProperty("UserName"));
	   	//UserName.sendKeys(prop.getProperty("UserName"));
	    driver.findElement(By.name(prop.getProperty("pwd"))).sendKeys(prop.getProperty("Passowrd"));
	   	//password.sendKeys(prop.getProperty("Password"));
	    driver.findElement(By.name(prop.getProperty("SignIn"))).click();
	    
	    String expected_OrhmTitle="Welcome";
		System.out.println("The title of the OhrmTitle is:"+expected_OrhmTitle);
		WebElement actual_OhrmTitle=driver.findElement(By.linkText("Welcome Admin"));
		String WelcomeText=actual_OhrmTitle.getText();
		System.out.println("The title of OhrmTitle is: "+WelcomeText);
		if(WelcomeText.contains(expected_OrhmTitle))
		{
			System.out.println("The title Matched-PASS");
		}
		else
		{
			System.out.println("The title not Matched-FAIL");
		}
		
	   }
	@Test(priority=2)
	public void Add_Employee() throws IOException
	{
		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
		Actions act=new Actions(driver);
		act.moveToElement(PIM).perform();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		driver.findElement(By.id("lastName")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		driver.findElement(By.id("btnSave")).click();
	//}
	//@Test(priority=3)
	//public void Validation()
	{
		String Expected="Madhu";
		WebElement Actual=driver.findElement(By.xpath("//*[@id='profile-pic']/h1"));
		String ActualName=Actual.getText();
		
		if(ActualName.contains(Expected))
		{
			System.out.println("Name Matched-PASS");
			sheet.getRow(1).createCell(2).setCellValue("Name Matched-PASS");
		}
		else
		{
			System.out.println("Name Not Matched-FAIL");
			sheet.getRow(1).createCell(2).setCellValue("Name Not Matched-FAIL");
		}
		FileOutputStream file1=new FileOutputStream("./src/com/Excel_Result/OHRM_AddEmployee_Hybrid.xlsx");
		workbook.write(file1);
	}
	}
@AfterTest
public void tearDown()
{
	 driver.close();
}
}
