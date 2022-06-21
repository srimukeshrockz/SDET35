package com.crm.organization;

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
import org.testng.annotations.Test;

import com.crm.Vtiger.genericUtilities.BaseClass;
import com.crm.Vtiger.genericUtilities.ExcelUtility;
import com.crm.Vtiger.genericUtilities.FileUtility;
import com.crm.Vtiger.genericUtilities.JavaUtility;
import com.crm.Vtiger.genericUtilities.WebDriverUtility;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganisationPage;
import com.crm.objectRepository.VerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationAssigmentTest extends BaseClass{
	@Test(groups = "regreesionTest")
public void createOrganizationAssigmentTest() throws Throwable {
//	WebDriver driver=null;
//	JavaUtility jLib=new JavaUtility();
//	ExcelUtility eLib=new ExcelUtility();
//	FileUtility fLib=new FileUtility();
//	WebDriverUtility wLib=new WebDriverUtility();
//	
//	String BROWSER = fLib.getPropertyKeyValue("browser");
//
//	if(BROWSER.equalsIgnoreCase("chrome"))
//	{
//		// launch the browser 
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//	}
//	else
//	{
//		System.out.println("select the correct browser and please check the code ");
//	}
//	
//	
//	
//	String URL = fLib.getPropertyKeyValue("url");
//	String UN=fLib.getPropertyKeyValue("username");
//	String PWD = fLib.getPropertyKeyValue("password");
//	
int ranNum = jLib.getRandomNumber();	
//	
//	wLib.waitPageToLoad(driver);
//	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.get(URL);
//	
//	LoginPage lpage=new LoginPage(driver);
//	lpage.loginToApplication(UN, PWD);
	HomePage hpage=new HomePage(driver);
	hpage.clickOrganizationLink();
	OrganisationPage orgpage=new OrganisationPage(driver);
	orgpage.clickCreateOrganizationLookupButton();
	String orgName = eLib.getDataFromExcelFile("Sheet1", 0, 0);
	orgpage.passDataAccountNameTextField(orgName+ranNum);
	orgpage.selectGroupRadioButton();
	orgpage.selectGroupDropDown();
	orgpage.passDataBilingAddressTextAreaField();
	orgpage.ClickSaveButton();
	VerificationPage verify=new VerificationPage(driver);
	WebElement check = verify.getCheck();
	//hpage.clickOrganizationLink();
	//driver.findElement(By.xpath("//a[.='Organization Name']")).click();

	//WebElement check = driver.findElement(By.xpath("//a[.='bottle918']/../../../../../../../../../tbody/tr[1]/td[1]/div[1]/table/tbody/tr/td[3]"));
	String text = check.getText();
	if(text.contains(orgName))
	{
		System.out.println("product is created with industry");
		//driver.quit();
	}
	else
	{
		System.out.println("not created");
		//driver.quit();
	
	}
	
	//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
	//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
	//driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	//driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("product");
	//driver.findElement(By.xpath("//input[@value='T']")).click();
	//WebElement drop = driver.findElement(By.xpath("//select[@class='small' and @name='assigned_group_id']"));
	//wLib.handleDropDownByVisibleText(drop, "Support Group");
	//Select sel=new Select(drop);
	//sel.selectByVisibleText("Support Group");
	//driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("qwertyui"+ranNum);
	//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	//WebElement check = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	
	}
}
