package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class CampaignsPage extends WebDriverUtility{
	ExcelUtility eLib=new ExcelUtility();
	// declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCampaignLoopupImg;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campgainNameTextField;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement radioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement groupDropDown;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement selectProductLoopupImg;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;
	
	
	
	// initialization
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	// utilization
	
	public WebElement getCreateCampaignLoopupImg()
	{
		return createCampaignLoopupImg;
	}
	public WebElement getCampgainNameTextField()
	{
		return campgainNameTextField;
	}
	public WebElement getRadioButton()
	{
		return radioButton;
	}
	public WebElement getGroupDropDown()
	{
		return groupDropDown;
	}
	public WebElement getSelectProductLoopupImg()
	{
		return selectProductLoopupImg;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	public void clickCreateCampaignLoopupImg()
	{
		createCampaignLoopupImg.click();
	}
	public void PassDataCampgainNameTextField(String data) throws Throwable
	{
		campgainNameTextField.sendKeys(data);
	}
	public void clickRadioButton()
	{
		radioButton.click();
	}
	public void clickOnGroupDropDown() throws Throwable
	{
		String dropDownValue = eLib.getDataFromExcelFile("Sheet1", 2, 2);
		handleDropDownByVisibleText(groupDropDown, dropDownValue);
	}
	public void clickSelectProductLoopupImg()
	{
		selectProductLoopupImg.click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	
}
