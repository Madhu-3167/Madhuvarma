package com.ScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;

public class Amazon_Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		String url="https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		File Amazon_Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(Amazon_Screenshot,new File("./ScreenShots/Madhu.png"));
		
	}

}
