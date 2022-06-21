package com.crm.organization;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class CreateOraganizationWithIndustryTest extends BaseClass {
	@Test(groups = "regreesionTest")
	public void createOraganizationWithIndustryTest() throws Throwable {
		// WebDriver driver=null;
//		WebDriverUtility wLib = new WebDriverUtility();
//		JavaUtility jLib = new JavaUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		FileUtility fLib = new FileUtility();
//		// launch browser
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		// maximize window
//		driver.manage().window().maximize();
//		// pass the URL 
//		String URL = fLib.getPropertyKeyValue("url");
//		String UN = fLib.getPropertyKeyValue("username");
//		String PWD = fLib.getPropertyKeyValue("password");
//		String BROWSER = fLib.getPropertyKeyValue("browser");
//		// generate random number
		int ranNum = jLib.getRandomNumber();
//		// page wait for 10 sec
//		wLib.waitPageToLoad(driver);
//		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(URL);										// pass the URL using property files 
//		// code for login page 
//		LoginPage lpage = new LoginPage(driver);
//		// pass UN and PWD 
//		lpage.loginToApplication(UN, PWD);
//		// display home page 
		HomePage hpage = new HomePage(driver);
		// click on Organisation link 
		hpage.clickOrganizationLink();
		OrganisationPage orgPage = new OrganisationPage(driver);
		// click on create create loop up page 
		orgPage.clickCreateOrganizationLookupButton();
		// pass data into text field using excel
		String data = eLib.getDataFromExcelFile("purchase", 1, 0);
		orgPage.passDataAccountNameTextField(data + ranNum);
		// clikc on member look up button
		orgPage.clickMemberOfLookUpButton();
		// get parent window address
		String parent = driver.getWindowHandle();
		// switch to child window using WebDriver Utilities
		wLib.switchToWindowUsingForEach(driver, "Vendors&action");
		// enter the data into search text field 
		orgPage.passDataOrgSearchTextField();
		// click serach button
		orgPage.ClickSearchButton();
		// select the dat from list 
		orgPage.FromListSelectOption();
		// handle the pop up and click on dismiss
		wLib.handleAlertPopUpDismiss(driver);
		// switch to parent 
		driver.switchTo().window(parent);
		// handle drop down and select option from the dropdown
		orgPage.selectIndustryDropDown();
		// select the radio button
		orgPage.selectGroupRadioButton();
		// select the option from group dropdown
		orgPage.selectGroupDropDown();
		// enter data into billing address text area field
		orgPage.passDataBilingAddressTextAreaField();
		// click onn save button
		orgPage.ClickSaveButton();
		// code for verification
		VerificationPage verify=new VerificationPage(driver);
		WebElement check = verify.getCheck();
		String text = check.getText();
		if (text.contains(data)) {
			System.out.println("product is created");
			//driver.quit();		
		} else {
			System.out.println("not created");
			//driver.quit();
		}
		
		System.out.println("given task done");
		
		// driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		// driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		// driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		// driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		// driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data+ranNum);
		// driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		// driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("product");
		// driver.findElement(By.xpath("//input[@class='crmbutton small
		// create']")).click();
		// driver.findElement(By.xpath("//a[.='product']")).click();
		/*
		 * Set<String> pop = driver.getWindowHandles(); for(String all:pop) {
		 * driver.switchTo().window(all); String url = driver.getCurrentUrl();
		 * if(url.contains("Vendors&action")) { Thread.sleep(3000);
		 * driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("product")
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath("//input[@class='crmbutton small create']")).
		 * click(); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//a[.='product']")).click(); Thread.sleep(3000);
		 * 
		 * Alert alt = driver.switchTo().alert(); alt.dismiss();
		 * 
		 * } }
		 */
		/*
		 * WebElement drop1 =
		 * driver.findElement(By.xpath("//select[@name='industry']")); Select get= new
		 * Select(drop1); List<WebElement> options = get.getOptions(); for(WebElement
		 * all:options) { String output = all.getText(); System.out.println(output); }
		 * //System.out.println(output);
		 * 
		 * // wLib.handleDropDownByVisibleText(drop1, "Construction");
		 * 
		 * // Select indus=new Select(drop1); //
		 * indus.selectByVisibleText("Construction");
		 * System.out.println("selected from drop down");
		 */
		//driver.findElement(By.xpath("//input[@value='T']")).click();
		
		//WebElement drop = driver.findElement(By.xpath("//select[@class='small' and @name='assigned_group_id']"));
		/*
		 * WebElement drop1 =driver.findElement(By.
		 * xpath("//select[@class='small' and @name='assigned_group_id']")); Select get=
		 * new Select(drop1); List<WebElement> options = get.getOptions();
		 * for(WebElement all:options) { String output = all.getText();
		 * System.out.println(output); }
		 * 
		 */
		//wLib.handleDropDownByVisibleText(drop, "Support Group");
		// Select sel=new Select(drop);
		// sel.selectByVisibleText("Support Group");
		//System.out.println("selected from group drop down");
		//driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("qwertyui" + ranNum);
		//System.out.println("description typed");
		//driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//WebElement check = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));

		

	}

}
