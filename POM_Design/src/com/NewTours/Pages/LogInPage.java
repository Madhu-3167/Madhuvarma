package com.NewTours.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {

	@FindBy(linkText="SIGN-ON")
	WebElement Signon;
	@FindBy(linkText="REGISTER")
	WebElement register;
	@FindBy(linkText="SUPPORT")
	WebElement support;
	@FindBy(linkText="CONTACT")
	WebElement contact;
	@FindBy(name="userName")
	WebElement UserName;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(name="login")
    WebElement Login;	
	
	public void SignOn()
	{
		Signon.click();
	}
	public void Register() 
	{
		register.click();
	}
	public void Support()
	{
		support.click();
	}
	public void Contact()
	{
		contact.click();
	}
	public void Login(String uName,String pwd)
	{
		UserName.sendKeys(uName);
		Password.sendKeys(pwd);
	    Login.click();
	}
}
