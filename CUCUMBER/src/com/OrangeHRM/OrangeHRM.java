package com.OrangeHRM;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRM {

	   WebDriver driver=null;
	   String url="https://opensource-demo.orangehrmlive.com/";
	   String UserName="Adminjhhgh";
	   String password="admin123";
	   
		@Given("^Open Chrome Browser and navigate to ORANGEHRM Application.$")
		
		public void Open_Chrome_Browser_and_navigate_to_ORANGEHRM_Application() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		}

		@When("^User enters UserName and Password and click on login button.$")
		public void User_enters_UserName_and_Password_and_click_on_login_button() throws Throwable {
		    
			driver.findElement(By.id("txtUsername")).sendKeys(UserName);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
		}

		@Then("^User should be able to login successfully and then close the application.$")
		public void User_should_be_able_to_login_successfully_and_then_close_the_application() throws Throwable {
        {
		try 
		
		{
			String expected_OrhmTitle="Welcome";
			System.out.println("The title of the OhrmTitle is:"+expected_OrhmTitle);
			WebElement actual_OhrmTitle=driver.findElement(By.linkText("Welcome Admin"));
			String WelcomeText=actual_OhrmTitle.getText();
			System.out.println("The title of OhrmTitle is: "+WelcomeText);
			if(WelcomeText.contains(expected_OrhmTitle))
			{
				System.out.println("The title Matched-PASS");
			}
		}
			catch(Exception e)
			{
				if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
            {
		    File ScreenShot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    Files.copy(ScreenShot,new File("./Screenshots/Invalid.png"));
			
				System.out.println("Login Failed-FAIL");
				
			}
		}
      driver.quit();
}
}
}