package com.Select_Class;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_DropDown {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="https://my.monsterindia.com/sponsered_popup.html";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement CurrentLocation=driver.findElement(By.className("border_grey1"));
		List<WebElement> CurrentLoc=CurrentLocation.findElements(By.tagName("option"));
		int Count=CurrentLoc.size();
		System.out.println("Count of elements in CurrentLoaction are:"+Count);
		for(int i=0;i<Count;i++)
		{
			System.out.println(CurrentLoc.get(i).getText());
		}
		Select selection=new Select(CurrentLocation);
		selection.selectByVisibleText("Mumbai");
		WebElement Industry=driver.findElement(By.id("id_industry"));
        Select selection1=new Select(Industry);
        selection1.selectByVisibleText("Any");
        selection1.selectByValue("4");
        selection1.selectByIndex(3);
        selection1.deselectByValue("65");
        selection1.deselectByIndex(2);
        selection1.deselectByVisibleText("Banking/Financial Services");
        
	}

}
