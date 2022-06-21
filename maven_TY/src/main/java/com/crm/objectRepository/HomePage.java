
package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	// declaration
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement OrganizationLink;
	
	@FindBy(xpath="//a[.='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productLink;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//a[.='Purchase Order']")
	private WebElement purchaseOrder;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement logout;
	
	
	
	// initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getOrganizationLink()
	{
		return OrganizationLink;
	}
	public WebElement getMoreLink()
	{
		return moreLink;
	}
	public WebElement getProductLink()
	{
		return productLink;
	}
	public WebElement getCampaignsLink()
	{
		return campaignsLink;
	}
	public WebElement getPurchaseOrder()
	{
		return purchaseOrder;
	}
	public WebElement getAdministrator()
	{
		return administrator;
	}
	public WebElement getLogout()
	{
		return logout;
	}
	
	
	
	
	
	
	public void allLink()
	{
		contactLink.click();
	}
	public void clickOrganizationLink()
	{
		OrganizationLink.click();
	}
	public void clickMoreLink()
	{
		moreLink.click();
	}
	public void clickProductLink()
	{
		productLink.click();
	}
	public void moveToCampaignsLink(WebDriver driver)
	{
		moveTo(driver, campaignsLink);
		campaignsLink.click();
	}
	public void clickPurchaseOrder(WebDriver driver)
	{
		moveTo(driver, purchaseOrder);
		purchaseOrder.click();
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
