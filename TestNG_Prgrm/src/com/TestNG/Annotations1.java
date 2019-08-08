package com.TestNG;

import org.testng.annotations.Test;

public class Annotations1 {
	@Test(priority=1)
      public void BrowserLaunch()
      {
		System.out.println("Firefox Browser Launch");
      }
	@Test(priority=2)
	  public void NavigateToGmailApplication()
	  {
		System.out.println("Navigate To Gmail Application");
	  }
	@Test(priority=3)
	  public void Login()
	  {
		System.out.println("Login To Gmail Application");
	  }
	@Test(enabled=false)
      public void Inbox()
      {
		System.out.println("Testing Inbox Functionality");
      }
}
