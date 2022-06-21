package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class PurchaseOrderPage extends WebDriverUtility{
	
	// declaration
	@FindBy(xpath="//a[.='Purchase Order']")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createPurchaseOrderLoopImg;
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']/../../../../tbody[1]/tr[4]/td[2]/img[1]")
	private WebElement selectVendorLookUp;
	
	@FindBy(xpath="//select[@name='postatus']")
	private WebElement statusDropDown;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement groupDropDown;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddress;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAddress;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement itemNamePopUp;
	
	@FindBy(xpath="//input[@id='qty1']")
	private WebElement qtyNum;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement logout;
	
	
	
	// initialization
	
	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	// utilization
	
	public WebElement getPurchaseOrderLink()
	{
		return purchaseOrderLink;
	}
	public WebElement getCreatePurchaseOrderLoopImg()
	{
		return createPurchaseOrderLoopImg;
	}
	public WebElement getPassDataToSubjectTextField()
	{
		return subjectTextField;
	}
	public WebElement getSelectVendorLookUp()
	{
		return selectVendorLookUp;
	}
	public WebElement getStatusDropDown()
	{
		return statusDropDown;
	}
	public WebElement getGroupRadioButton()
	{
		return groupRadioButton;
	}
	public WebElement getGroupDropDown()
	{
		return groupDropDown;
	}
	public WebElement getBillingAddress()
	{
		return billingAddress;
	}
	public WebElement getShippingAddress()
	{
		return shippingAddress;
	}
	public WebElement getItemNamePopUp()
	{
		return itemNamePopUp;
	}
	public WebElement getQtyNum()
	{
		return qtyNum;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	public WebElement getAdministrator()
	{
		return administrator;
	}
	public WebElement getLogout()
	{
		return logout;
	}


	
	
	
	
	
	
	
	
	
	
	public void clickPurchaseOrderLink()
	{
		purchaseOrderLink.click();
	}
	public void clickCreatePurchaseOrderLoopImg()
	{
		createPurchaseOrderLoopImg.click();
	}
	public void passDataToSubjectTextField(String item)
	{
		subjectTextField.sendKeys(item);
	}
	public void clickSelectVendorLookUp()
	{
		selectVendorLookUp.click();
	}
	public void selectStatusDropDown(String created)
	{
		handleDropDownByVisibleText(statusDropDown, created);
	}
	public void selectGroupRadioButton()
	{
		groupRadioButton.click();
	}
	public void selectGroupDropDown(String GroupDropDown)
	{
		handleDropDownByVisibleText(groupDropDown, GroupDropDown);
	}
	public void passDataBillingAddress(String billingAddresss)
	{
		billingAddress.sendKeys(billingAddresss);
	}
	public void passShippingAddress(String shippingAddresss)
	{
		shippingAddress.sendKeys(shippingAddresss);
	}
	public void clickItemNamePopUp()
	{
		itemNamePopUp.click();
	}
	public void EnterQtyNum(int num)
	{
		qtyNum.sendKeys("1");
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public void moveToAdmin(WebDriver driver)
	{
		moveTo(driver, administrator);
	}
	public void clickLogout(WebDriver driver)
	{
		moveTo(driver, logout);
		logout.click();
	}
	

	
	
	

}
