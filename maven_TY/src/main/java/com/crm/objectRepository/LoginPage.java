package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	// Declaration 
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement submitBtn;
	
	// initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization and business library
	public WebElement getUserName()
	{
		return userName;
	}
	public  WebElement getPassword()
	{
		return password;
	}
	public WebElement getClick()
	{
		return submitBtn;
	}
	public void loginToApplication(String username, String passWord )
	{
		userName.sendKeys(username);
		password.sendKeys(passWord);
		submitBtn.click();
	}


}
