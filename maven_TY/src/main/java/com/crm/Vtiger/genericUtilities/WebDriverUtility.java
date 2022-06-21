package com.crm.Vtiger.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * it contains all the reusable code for actions of done in webDriver
 * @author DELL
 *
 */
public class WebDriverUtility {
	/**
	 * this code is used to move cursor to an element
	 * @param driver
	 * @param element
	 */
	public void moveTo(WebDriver driver,WebElement element)
	{
		Actions moveto=new Actions(driver);
		moveto.moveToElement(element).perform();
	}
	/**
	 * this method will click on element
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver,WebElement element)
	{
		Actions clickon=new Actions(driver);
		clickon.contextClick(element).perform();
	}
	
	/**
	 * this code used to perform double click on an element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver, WebElement element)
	{
		Actions Dclick=new Actions(driver);
		Dclick.doubleClick(element).perform();
	}
	
	/**
	 * this code is used to perform enter button in keyborad
	 * @param driver
	 * @param element
	 */
	public void clickOnEnterButton(WebDriver driver, WebElement element)
	{
		Actions enter=new Actions(driver);
		enter.sendKeys(Keys.ENTER).perform();		
	}
	/**
	 * this is code is used to perform click using actions class
	 * @param driver
	 * @param element
	 */
	public void clickOn(WebDriver driver,WebElement element)
	{
		Actions clickOnElement=new Actions(driver);
		clickOnElement.click().perform();
	}
	/**
	 * this method wait for 10 seconds
	 * @param driver
	 */
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * this is used to wait until page to load the javascript  
	 * @param driver
	 */
	public void waitForPageToLoadJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * this code is used to wait until the element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this code will wait till it gets the title
	 * @param driver
	 * @param element
	 */
	public void waitForTitleContains(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("element"));
	}
	/**
	 * use fluent wait or here we change polling time from default time 500ms to user defined
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustome(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we are giving custom time
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<10)
		{
			 try{
				 element.click();
			 }
			 catch(Exception e)
			 {
				 Thread.sleep(1000);
				 count++;
				 }
			 }
	}
	
	/**
	 *  this code to is used to switch from one window to another using iterator 
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver,String partialWindow)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if(currentWindow.contains(partialWindow))
			{
				break;
			}
		}
	}
	public void switchToWindowUsingForEach(WebDriver driver, String partialWindow)
	{
		Set<String> allids = driver.getWindowHandles();
		for(String value:allids)
		{
			driver.switchTo().window(value);
			String currentUrl=driver.getCurrentUrl();
			if(currentUrl.contains(partialWindow))
			{
				break;
			}			
		}
	}
	
	/**
	 * this is used to swtich to another frame using index 
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this code is used to switch to another frame using attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void SwitchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * this code is used to another from using element
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this is used to go back to the main frame from any frame
	 * @param driver
	 */
	public void switchToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this code is used to switch the control from web page to alert pop up and click on accept button
	 * @param driver
	 */
	public void handleAlertPopUpAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this code is used to switch to alert pop up and click on dismiss button
	 * @param driver
	 */
	public void handleAlertPopUpDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this is code to handle drop down by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * this code is used to handle drop down using value  
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * this code is used to handle drop down using visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDownByVisibleText(WebElement element,String visibleText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * this code is used to take screen shot 
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws Throwable
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+screenshotName+".png");
		Files.copy(src, dst);
	}
	/**
	 * this is used perform on scroll down action 
	 * @param driver
	 */
	public void srcollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("windown.scrollBy(0,10000)");
	}
	

}
