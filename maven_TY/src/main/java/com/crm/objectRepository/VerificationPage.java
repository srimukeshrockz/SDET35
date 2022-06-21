package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationPage {
	
	//declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement check;
	
	// initalization
	
	public VerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization 
	
	public WebElement getCheck()
	{
		return check;
	}
	

}
