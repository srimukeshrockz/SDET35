package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemsPage {

	// declaration
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement itemSearchTextField; 
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='qwerty']")
	private WebElement selectFromList;
	
	
	
	
	
	
	
	
	// initialization
	public ItemsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	
	
	// utilization
	public WebElement getItemSearchTextField()
	{
		return itemSearchTextField;
	}
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	public WebElement getSelectFromList()
	{
		return selectFromList;
	}


	
	
	
	
	
	
	
	public void passItemSearchTextField(String itemName)
	{
		itemSearchTextField.sendKeys(itemName);
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
