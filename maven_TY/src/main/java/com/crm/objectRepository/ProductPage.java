package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class ProductPage extends WebDriverUtility {

	ExcelUtility eLib=new ExcelUtility();
	// declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductLookupImg;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productTextField;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement vendorLookupButton;
	
	@FindBy(xpath="//input[@type='submit' and @name='button']")
	private WebElement saveButton;
	
	
	
	
	
	// initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	// utilization
	public WebElement getCreateProductLookupImg()
	{
		return createProductLookupImg;
	}
	public WebElement getProductTextField()
	{
		return productTextField;
	}
	public WebElement getVendorLookupButton()
	{
		return vendorLookupButton;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	public void clickCreateProductLookupImg()
	{
		createProductLookupImg.click();
	}
	public void passDataProductTextField(String data) throws Throwable
	{	
		productTextField.sendKeys(data);
	}
	public void clickVendorLookupButton()
	{
		vendorLookupButton.click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}

	
	
	
	
}
