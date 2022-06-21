package com.crm.contactGroup.Vitger;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.genericUtilities.BaseClass;
import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationspagePopUpPage;
import com.crm.objectRepository.VerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.crm.Vtiger.genericUtilities.ItestListnersImplements.class)
public class CreateContactOrganisationTest extends BaseClass{
@Test(groups = "smokeTest")
	public void  createContactOrganisationTest() throws Throwable
	{
//	WebDriver driver=null;
//	
//	JavaUtility jLib=new JavaUtility();
//	ExcelUtility eLib=new ExcelUtility();
//	FileUtility fLib=new FileUtility();
//	WebDriverUtility wLib=new WebDriverUtility();
//	String URL = fLib.getPropertyKeyValue("url");
//	String UN=fLib.getPropertyKeyValue("username");
//	String PWD = fLib.getPropertyKeyValue("password");
//	String BROWSER = fLib.getPropertyKeyValue("browser");
//	
	int ranNum = jLib.getRandomNumber();	
//	
//	
//	if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//	}
//	else
//	{
//		System.out.println("browser not add, add which browser should be lauched and add correct file");
//	}
//	// this code will wait for 10 sec
//	wLib.waitPageToLoad(driver);
//	// pass URL 
//	driver.get(URL);
//	// Login using username and password 
//	LoginPage Login=new LoginPage(driver);
//	Login.loginToApplication(UN, PWD);
//	//click on contact link
	HomePage hmpage=new HomePage(driver);
	hmpage.getContactLink().click();
	ContactPage cpage=new ContactPage(driver);
	// pass data from excel sheet into contact texf field 
	String contact = eLib.getDataFromExcelFile("Sheet1", 1, 0);
	cpage.createContact();
	cpage.passDataIntoLastName(contact+ranNum);
	cpage.groupRadio();
	cpage.handleGrpDropDown();
	
	cpage.clickOrganizationLookipImg();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
	//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
	//driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	//driver.findElement(By.xpath("//a[.='Contacts']")).click();
	
	
	//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("qwert"+ranNum);
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	//to fetch parent id
	
	String parent = driver.getWindowHandle();
	
	// to fetch id of all the windows
	
	wLib.switchToWindowUsingForEach(driver, "Accounts&action");
	//
	
	
	//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("product"); // it gives input to the text field as "product" 
	OrganizationspagePopUpPage OrgPagePopUp=new OrganizationspagePopUpPage(driver);
	

	OrgPagePopUp.PassData();
	//driver.findElement(By.xpath("//input[@name='search']")).click();		// click on the search button
	
	OrgPagePopUp.clickOnSearchButton();
	//driver.findElement(By.xpath("//a[.='product']")).click();		//click on the  result
	OrgPagePopUp.clickOnProduct();
	
	driver.switchTo().window(parent); // switch to parent window

	/*
	 * Set<String> allid = driver.getWindowHandles(); for(String value:allid)
	 * //store all the id's in value and enter then enter the loop {
	 * driver.switchTo().window(value); //switch to each and every window onw by one
	 * String newurl = driver.getCurrentUrl(); //get current url and store it in
	 * newurl String text = newurl.toString(); //convert to string
	 * if(text.contains("Accounts&action")) // check for the condition {
	 * System.out.println("switched to child broswer");
	 * driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(
	 * "product"); // it gives input to the text field as "product"
	 * driver.findElement(By.xpath("//input[@name='search']")).click(); // click on
	 * the search button driver.findElement(By.xpath("//a[.='product']")).click();
	 * //click on the result driver.switchTo().window(parent); // switch to parent
	 * window System.out.println("switched to parent"); } }
	 */	//loop gets terminated
	
	//driver.findElement(By.xpath("//input[@value='T']")).click();		// click on group radio button
	
	//WebElement drop = driver.findElement(By.xpath("//select[@name='assigned_group_id']")); // selects drop down element
	
	//wLib.handleDropDownByVisibleText(drop, "Support Group");
	//Select sel=new Select(drop);				
	//sel.selectByVisibleText("Support Group");					// selects 1 option from the drop down using visibleText
	
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();			// click on save button
	cpage.clickOnSaveButton();
	VerificationPage verify=new VerificationPage(driver);
	//WebElement verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));		// select the heading for verification 
	//Thread.sleep(2000);
	WebElement text = verify.getCheck();				// get the text from the element(from the heading)
	String check = text.getText();	// converts the element to string
	//WebElement admin = cpage.getAdministrator();
	Assert.assertTrue(check.contains(contact));
	System.out.println("contact created ");
	//Assert.fail();
	//if(check.contains(contact))			// check for the conditions
	//{	
		//System.out.println("contact created ");		// if condition satisfy it will print the statement
		//wLib.moveTo(driver, admin);
		//cpage.clickSignOut();
		//driver.quit();								// the complete gets close
	
	//}
	//else
	//{
		//System.out.println("contact not created");		// condition not satisfy else will get executed
		//driver.quit();
	//}
	
}
}
