package com.crm.Vtiger.genericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListnersImplements implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		System.out.println(testName+"====executing====");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		 try
		 {
			 FileUtils.copyFile(src, new File("./screenshot/"+testName+".png"));
		 }
		 catch (Exception e) {
			e.printStackTrace();
		}


		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
