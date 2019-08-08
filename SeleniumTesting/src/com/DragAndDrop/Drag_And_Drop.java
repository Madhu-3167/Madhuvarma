package com.DragAndDrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {

	public static void main(String[] args) {
      WebDriver driver=null;	
      String url="https://jqueryui.com/droppable/";
      System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
      driver=new ChromeDriver();
      driver.get(url);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
      driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
      WebElement Drag_Element=driver.findElement(By.id("draggable"));
      String Draggable=Drag_Element.getText();
      System.out.println("The Name of the Draggable is"+Draggable);
      WebElement Drop_Element=driver.findElement(By.id("droppable"));
      String Droppable=Drop_Element.getText();
      System.out.println("The Name of the Droppable is :"+Draggable);
      Actions act=new Actions(driver);
      act.dragAndDrop(Drag_Element, Drop_Element).perform();
      driver.switchTo().defaultContent();
      driver.findElement(By.linkText("Sortable")).click();
	}

}
