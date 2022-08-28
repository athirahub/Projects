package com.NaveenAutomation.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getLastRow(String excelfile, String sheetname) throws IOException {
		file = new FileInputStream(excelfile);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;

	}

	public static int getLastColumn(String excelfile, String sheetname, int rownumber) throws IOException {
		file = new FileInputStream(excelfile);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownumber);
		int columnCount = row.getLastCellNum();
		workbook.close();
		file.close();
		return columnCount;
	}
	
	public static String getCellData(String excelfile, String sheetname, int rownumber,int coloumnnumber) throws IOException {
		file = new FileInputStream(excelfile);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);
		cell=sheet.getRow(rownumber).getCell(coloumnnumber);
		cell.setCellType(cell.CELL_TYPE_STRING);
		return cell.getStringCellValue();
}
}
