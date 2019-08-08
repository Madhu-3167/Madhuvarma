package com.Cookies_Clear;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff_Mail {

	public static void main(String[] args) {
		WebDriver driver=null;
		String url="http://register.rediff.com/register/register.php?FormName=user_details";
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Set<Cookie>RediffMailHomepageCookies=driver.manage().getCookies();
		int CookiesCount=RediffMailHomepageCookies.size();
		System.out.println("The total number of cookies are:"+CookiesCount);
		for(Cookie var:RediffMailHomepageCookies)
		{
			System.out.println(var);
		}
		driver.manage().deleteAllCookies();
		RediffMailHomepageCookies=driver.manage().getCookies();
		CookiesCount=RediffMailHomepageCookies.size();
		System.out.println("The Total number of Cookies are:"+CookiesCount);
		
	}

}
