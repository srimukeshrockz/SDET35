package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPoPUpPage {
	
	// declaration
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement vendorTextFieldInPopup;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='hari']")
	private WebElement selectFromList;
	
	
	
	// initalization
	public VendorPoPUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// utilization
	public WebElement getVendorTextFieldInPopup()
	{
		return vendorTextFieldInPopup;
	}
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	public WebElement getSelectFromList()
	{
		return selectFromList;
	}
	
	
	
	
	
	
	// business library 
	public void passDataInVendorTextFieldInPopup(String data)
	{
		vendorTextFieldInPopup.sendKeys(data);
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	public void clickSelectFromList()
	{
		selectFromList.click();
	}
	

}
