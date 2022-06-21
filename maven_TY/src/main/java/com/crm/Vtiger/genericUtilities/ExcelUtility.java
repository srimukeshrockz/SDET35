package com.crm.Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this code to fetch data from the excel sheet 
 * @author DELL
 *
 */
public class ExcelUtility {
	/**
	 * this code will fetch data from the excel
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcelFile(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fileinputstream= new FileInputStream("./src/test/resources/Book3.xlsx");
		Workbook book = WorkbookFactory.create(fileinputstream);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}

	/**
	 * this code will insert  data into the excel
	 * 
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public String inserDataIntoExcelFile(String SheetName,int rowNum,int cellNum,String data) throws Throwable
	{
		FileInputStream fileinputstream= new FileInputStream("./src/test/resources/Book3.xlsx");
		Workbook book = WorkbookFactory.create(fileinputstream);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fout =new FileOutputStream("./src/test/resources/Book3.xlsx");
		book.write(fout);
		return data;
	}
	}
	

