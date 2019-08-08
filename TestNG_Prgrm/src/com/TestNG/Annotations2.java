package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations2 {
	@BeforeTest
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
	@AfterTest
	public void GmailApplicationClose()
	{
		System.out.println("Gmail Application Close");
	}
}
