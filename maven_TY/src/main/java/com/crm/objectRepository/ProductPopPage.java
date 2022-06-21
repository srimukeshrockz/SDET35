
package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPopPage {

	// declaration
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement serachTextFildInPopup;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='qwerty']")
	private WebElement selectFromList;
	
	
	
	
	
	// initialization
	public ProductPopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	// utilization
	public WebElement getSerachTextFildInPopup()
	{
		return serachTextFildInPopup;
	}
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	public WebElement getSelectFromList()
	{
		return selectFromList; 
	}
	

	
	
	
	
	
	
	
	
	
	public void passDataSerachTextFildInPopup(String data )
	{
		serachTextFildInPopup.sendKeys(data);
	}
	public void clickSearchButton()
	{
		searchButton.click();	
	}
	public void selectFromList()
	{
		selectFromList.click();
	}

	
	
}
