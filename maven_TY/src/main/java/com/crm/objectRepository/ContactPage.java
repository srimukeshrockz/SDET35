package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class ContactPage extends WebDriverUtility {
	WebDriver driver=null;
	// declaration
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createlookButtin;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnameTxtField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']/../../../tr[5]/td[2]/img[1]")
	private WebElement OrganizationLookupImg;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement groupDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement SignOut;
	
	
	// initialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// utilization
	
	public WebElement getCreateLookButtin()
	{
		return createlookButtin;
	}
	public WebElement getLastnameTxtField()
	{
		return lastnameTxtField;
	}
	public WebElement getOrganizationLookupImg()
	{
		return OrganizationLookupImg;
	}
	public WebElement groupRadioButton()
	{
		return groupRadioButton;
	}
	public WebElement getGroupDropDown()
	{
		return groupDropDown;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	public WebElement getAdministrator()
	{
		return administrator;
	}
	public WebElement getSignOut()
	{
		return SignOut;
	}
	
	
	
	
	public void createContact()    
	{
		createlookButtin.click();
	}
	
	public void passDataIntoLastName(String lastname)
	{
	
		lastnameTxtField.sendKeys(lastname);
}
	public void groupRadio()
	{
		groupRadioButton.click();
	
	}
	public void handleGrpDropDown()
	{
	handleDropDownByVisibleText(groupDropDown, "Support Group");
	
	}
	//saveButton.click();
		//WebDriver driver = null;
		//check.getText();
		//String text = verify.toString();
		//moveTo(driver, administrator);
		//SignOut.click();
	
	public void clickOrganizationLookipImg()
	{
		OrganizationLookupImg.click();
	}
	public void moveToAdministrator()
	{
		
		moveTo(driver, administrator);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	public void clickSignOut()
	{
		SignOut.click();
	}
	
	}
	

