package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations3 {

	WebDriver driver=null;
	@BeforeMethod
	public void gmailApplicationLaunch()
	{
		System.out.println("Gmail Application Launch");
	}
	@Test(priority=1)
	public void Inbox()
	{
		System.out.println("Testing Inbox Functionality");
	}
	@Test(priority=2)
	public void SentMail()
	{
		System.out.println("Testing Sentmail Functionality");
	}
	@Test(enabled=false)
	public void ComposeMail()
	{
		System.out.println("Testing ComposeMail Functionality");
	}
	@AfterMethod
	public void GmailApplicationClose()
	{
		System.out.println("Gmail Application Close");
	
}
}