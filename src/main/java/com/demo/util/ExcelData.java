package com.demo.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	Workbook wb;
	int rowCount, colCount;
	String sheetName, excelName;

	String getCellData(String sheetName, int row, int col) {
		String cellData = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return cellData;
	}

	int getLastRowCount(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}

	int getLastColumnCount(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}

	public Object[][] getTestData(String xlName, String sheetName) {

		File src = new File(System.getProperty("user.dir") + "/TestData/" + xlName);
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}

		rowCount = getLastRowCount(sheetName);
		colCount = getLastColumnCount(sheetName);
		String[][] testData = new String[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = getCellData(sheetName, i, j);
			}
		}
		return testData;
	}
}
