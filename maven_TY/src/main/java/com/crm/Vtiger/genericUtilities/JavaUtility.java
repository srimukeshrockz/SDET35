package com.crm.Vtiger.genericUtilities;

import java.util.Date;

import java.util.Random;
/**
 * it contains java specific libraries like getRandomNumber and getSystemDate
 * @author DELL
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate number Random number within the range of 1000
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int ranNum = random.nextInt(1000);
		return ranNum;
	}
	/**
	 * it is used to get current date based on system format 
	 * @return
	 */
	public String getSystemDateAndTimeInIndianFormat()
	{
		Date date=new Date();
		return	date.toString();

	}
	
	/**
	 * it is used to get current date based on YYYY MM DD
	 * @return
	 */
	public String getSystemDateAndTimeInRequiredFormat()
	{
		Date date=new Date();
		String value = date.toString();
		
	String yyyy = value.split(" ")[5];
	String mm = value.split(" ")[1];
	String dd = value.split(" ")[2];
	String finalformat = yyyy+" "+mm+" "+dd;
	System.out.println(finalformat);
	return finalformat;
	}
	}