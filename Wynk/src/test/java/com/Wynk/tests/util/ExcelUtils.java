package com.Wynk.tests.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends CommonUtil {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;

	public ExcelUtils(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return rowCount;

	}

	public static int getColCount() {
		int colCount = 0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return colCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).toString();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {

			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			logger.info(cellData);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void writeIntoCellStatus(String excelPath, String sheetName, int r, String assignCellValue) {

		try {
			workbook = new XSSFWorkbook(excelPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		int colNum = -1;
		if (sheet == null) {
			logger.info("Sheet is null");
		}
		row = sheet.getRow(0);
		cell = row.getCell(1);

		for (int i = 0; i < getColCount(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Status")) {
				colNum = i;
			}
		}

		row = sheet.getRow(r);
		if (row == null) {
			if (r >= getRowCount()) {
				logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Row number " + r
						+ " is  larger than total row count" + "\n");
			}
			logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Row is null" + "\n");
		}

		cell = row.getCell(colNum);
		if (cell == null) {
			logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Cell is null" + "\n");
		}

		cell.setCellValue(assignCellValue);

		try {
			FileOutputStream fileOut = new FileOutputStream(excelPath, true);
			try {
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
				logger.info("Save and Quit workbook");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void writeIntoCellQuoteNumber(String excelPath, String sheetName, int r, String assignCellValue) {

		try {
			workbook = new XSSFWorkbook(excelPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		int colNum = -1;
		if (sheet == null) {
			logger.info("Sheet is null");
		}
		row = sheet.getRow(0);
		cell = row.getCell(1);

		for (int i = 0; i < getColCount(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Quote Number")) {
				colNum = i;
			}
		}

		row = sheet.getRow(r);
		if (row == null) {
			if (r >= getRowCount()) {
				logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Row number " + r
						+ " is  larger than total row count" + "\n");
			}
			logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Row is null" + "\n");
		}

		cell = row.getCell(colNum);
		if (cell == null) {
			logger.info("\n" + "\n" + "Alert:-----------------" + "\n" + "Cell is null" + "\n");
		}

		cell.setCellValue(assignCellValue);

		try {
			FileOutputStream fileOut = new FileOutputStream(excelPath, true);
			try {
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
				logger.info("Save and Quit workbook");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Map<Object, Object> conversion() {
		Map<Object, Object> datamap = new HashMap<Object,Object>();
		for (int i = 0; i < getRowCount(); i++) {

			for (int j = 0; j < getColCount(); j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j));
			}
			logger.info(datamap);

		}
		logger.info(datamap);
		return datamap;
	}

}