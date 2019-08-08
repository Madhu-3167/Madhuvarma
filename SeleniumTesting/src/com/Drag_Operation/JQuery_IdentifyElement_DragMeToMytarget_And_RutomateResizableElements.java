package com.Drag_Operation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuery_IdentifyElement_DragMeToMytarget_And_RutomateResizableElements {

	public static void main(String[] args) {
		WebDriver driver=null;
       String url="https://jqueryui.com/draggable/";
       System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
       driver=new ChromeDriver();
       driver.get(url);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
       WebElement drag_Element=driver.findElement(By.id("draggable"));
       String dragElement_text=drag_Element.getText();
       System.out.println("The Drag Element text is:"+dragElement_text);
       driver.switchTo().defaultContent();
       driver.findElement(By.linkText("Resizable")).click();
       System.out.println("The title of the resizable page is :"+driver.getTitle());
	}

}
