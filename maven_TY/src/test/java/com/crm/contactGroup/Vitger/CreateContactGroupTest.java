package com.crm.contactGroup.Vitger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.crm.objectRepository.VerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.Vtiger.genericUtilities.ItestListnersImplements.class)
public class CreateContactGroupTest extends BaseClass{
@Test(groups = "smokeTest")
public void createContactGroupTest() throws Throwable 
{
	
	
//	
//	WebDriver driver=null;
//	JavaUtility jLib=new JavaUtility();
//	ExcelUtility eLib=new ExcelUtility();
//	FileUtility fLib=new FileUtility();
//	WebDriverUtility wLib=new WebDriverUtility();
//	String URL = fLib.getPropertyKeyValue("url");
//	String UN=fLib.getPropertyKeyValue("username");
//	String PWD = fLib.getPropertyKeyValue("password");
//	String BROWSER = fLib.getPropertyKeyValue("browser");
//	in local branch i have changed this comment
	int ranNum = jLib.getRandomNumber();	
//	
//	if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		// launch the browser 
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		// maximize window
//				driver.manage().window().maximize();
//	}
//	else
//	{
//		System.out.println("browser not add, add which browser should be lauched and add correct file");
//	}
//	wLib.waitPageToLoad(driver);
//		// pass URL 
//	driver.get(URL);
//	// to enter the data in username and passwrod text field
//	
//	LoginPage loginPage=new LoginPage(driver);
//	loginPage.loginToApplication(UN, PWD);
//	
	HomePage homepge=new HomePage(driver);
	//click on contact button
	homepge.allLink();
	
	// code to create a contact and verify
	ContactPage contctpage=new ContactPage(driver);
	String contact = eLib.getDataFromExcelFile("Sheet2", 0, 0);
	contctpage.createContact();
	contctpage.passDataIntoLastName(contact+ranNum);
	contctpage.groupRadio();
	contctpage.handleGrpDropDown();
	contctpage.clickOnSaveButton();
	VerificationPage verify=new VerificationPage(driver);
	WebElement title = verify.getCheck();
	String confirm = title.getText();
	
	//WebElement admin = contctpage.getAdministrator();		
	Assert.assertTrue(confirm.contains(contact));
	System.out.println("contact created");
	//Assert.fail();
	//if(confirm.contains(contact))
	//{
		//System.out.println("contact created ");
		// move cursor to administrator 
		//wLib.moveTo(driver, admin);
		// click on  sign out
		//contctpage.getSignOut().click();
		// quit the browser
		//driver.quit();
	//}
	//else
	//{
		//System.out.println("contact is not created");
	//}
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		//driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//driver.findElement(By.xpath("//a[.='Contacts']")).click(); // click on contact link 	
	//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("qwertyasdf"+ranNum);
	//driver.findElement(By.xpath("//input[@value='T']")).click();
	//contctpage.getLastnameTxtField();
	//contctpage.groupRadioButton();
	//contctpage.getGroupDropDown();
	//WebElement drop = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
	//wLib.handleDropDownByVisibleText(drop, "Support Group");
	//Select sel=new Select(drop);
	//sel.selectByVisibleText("Support Group");
	//contctpage.getSaveButton();
	//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	//WebElement check = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	//String verify = check.getText();
	//String text = verify.toString();

	}
}
