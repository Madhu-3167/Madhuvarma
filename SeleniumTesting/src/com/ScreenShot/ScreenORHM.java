package com.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenORHM {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		String url="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int linksCount=links.size();
		{
			System.out.println("The count of the links is:"+linksCount);
			
		}
		for(int i=0;i<linksCount;i++)
		{
			String linkName=links.get(i).getText();
			System.out.println(i+linkName);
			links.get(i).click();
		File NewTours_Screenshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(NewTours_Screenshots,new File("./ScreenShots/OrangeHrm/"+linkName+".png"));
        Thread.sleep(3000);
        driver.navigate().back();
		links=driver.findElements(By.tagName("a"));
	}
	}
}
