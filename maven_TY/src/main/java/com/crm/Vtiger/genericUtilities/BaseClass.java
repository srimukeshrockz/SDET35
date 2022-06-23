package com.crm.Vtiger.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 
	public static WebDriver sdriver;
	public WebDriver driver;
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DataBaseConnection dLib=new DataBaseConnection();
	
	/**
	 * connecting to Database 
	 */
	@BeforeSuite(groups = {"smokeTest","regreesionTest"})
			public void connectToDataBase()
			{
		dLib.connectToDB();
			}
	
	/**
	 * launch the browser
	 * @throws Throwable 
	 */
	//@Parameters("BROWSER")  // this line is parallel execution
	@BeforeClass(groups = {"smokeTest","regreesionTest"})
	public void launchTheBrowser() throws Throwable
	{
		String BROWSER = System.getProperty("browser");
		String url= System.getProperty("url");
		//String BROWSER = fLib.getPropertyKeyValue("browser");
		//String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		// maximaize the page 
		driver.manage().window().maximize();
		//sdriver=driver;
		// implicit wait
		wLib.waitPageToLoad(driver);
		
		// pass the url
		driver.get(url);
		
	}
	/**
	 * login to the application
	 * @throws Throwable 
	 */
	@BeforeMethod(groups = {"smokeTest","regreesionTest"})
	public void LoginToApplication() throws Throwable
	{
		String UN = fLib.getPropertyKeyValue("username");
		String PWD = fLib.getPropertyKeyValue("password");
		LoginPage lpage=new LoginPage(driver);
		lpage.loginToApplication(UN, PWD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regreesionTest"})
	public void logout()
	{
		HomePage hpage=new HomePage(driver);
		hpage.moveToAdmin(driver);
		hpage.clickLogout(driver);
	}
	
	
	
	
	
	
	/**
	 * close the browser
	 */
	@AfterClass(groups = {"smokeTest","regreesionTest"})
	public void closeTheBrowser()
	{
		driver.quit();
	}
	
	
	
	/**
	 * close the database connection
	 */
	@AfterSuite(groups = {"smokeTest","regreesionTest"})
	public void CloseTheDbConnection()
	{
		dLib.closeConnection();
	}
	
}
