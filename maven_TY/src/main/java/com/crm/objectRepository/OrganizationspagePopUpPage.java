package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.ExcelUtility;

public class OrganizationspagePopUpPage {
	
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement serachTextField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButtun;
	
	@FindBy(xpath="//a[.='product']")
	private WebElement selectProduct;
	
	

	// initialzation
	public OrganizationspagePopUpPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization 
	public WebElement getSerachTextField() {
		return serachTextField;
	}
	public WebElement getSearchButtun()
	{
		return searchButtun;
	}
	public WebElement getSelectProduct()
	{
		return selectProduct;
	}

	
	
	
	
	
	
	public void PassData()
	{
		serachTextField.sendKeys("contact");
	}
	public void clickOnSearchButton()
	{
		searchButtun.click();
	}
	public void clickOnProduct()
	{
		selectProduct.click();
	}
	
	
	
	
	

}
