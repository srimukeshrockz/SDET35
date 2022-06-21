package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility {

	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	// declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationLookupButton;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountNameTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement memberOfLookUpButton;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement orgSearchTextField;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='product']")
	private WebElement selectOption;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//select[@class='small' and @name='assigned_group_id']")
	private WebElement groupDropDown;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement bilingAddressTextAreaField;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;
	

	
	
	// initialization
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization
	public WebElement getCreateOrganizationLookupButton()
	{
		return CreateOrganizationLookupButton;
	}
	public WebElement getAccountNameTextField()
	{
		return accountNameTextField;
	}
	public WebElement getMemberOfLookUpButton()
	{
		return memberOfLookUpButton;
	}
	public WebElement getOrgSearchTextField()
	{
		return orgSearchTextField;
	}
	public WebElement getSearchButton()
	{
		return searchButton;
	}
	public WebElement getSelectOption()
	{
		return selectOption;
	}
	public WebElement getIndustryDropDown()
	{
		return industryDropDown;
	}
	public WebElement getGroupRadioButton()
	{
		return groupRadioButton;
	}
	public WebElement getGroupDropDown()
	{
		return groupDropDown;
	}
	public WebElement getBilingAddressTextAreaField()
	{
		return bilingAddressTextAreaField;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	
	
	
	
	
	public void clickCreateOrganizationLookupButton()
	{
		CreateOrganizationLookupButton.click();
	}
	public void passDataAccountNameTextField(String data)
	{
		accountNameTextField.sendKeys(data);
	}
	public void clickMemberOfLookUpButton()
	{
		memberOfLookUpButton.click();
	}
	public void passDataOrgSearchTextField()
	{
		orgSearchTextField.sendKeys("product");
	}
	public void ClickSearchButton()
	{
		searchButton.click();
	}
	public void FromListSelectOption()
	{
		selectOption.click();
	}
	public void selectIndustryDropDown() throws Throwable
	{
		
		String option = eLib.getDataFromExcelFile("Sheet1", 5, 0);
		handleDropDownByVisibleText(industryDropDown, option);
	}
	public void selectGroupRadioButton()
	{
		groupRadioButton.click();
	}
	public void selectGroupDropDown() throws Throwable
	{
		String drop = eLib.getDataFromExcelFile("Sheet1", 2, 2);
		handleDropDownByVisibleText(groupDropDown, drop);
	}
	public void passDataBilingAddressTextAreaField() throws Throwable
	{
		String address = eLib.getDataFromExcelFile("Sheet1", 0, 0);
		bilingAddressTextAreaField.sendKeys(address);
	}
	public void ClickSaveButton()
	{
		saveButton.click();
	}
	
	
	
	
}
