package com.gcrapp.selenium.framwork.datareader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;

public class DataReader {

	@DataProvider(name = "LoginData")
	public Object[][] readData() {
		String[][] inputData = null;
		InputStream f = null;
		try {
			f = new FileInputStream(
					"C:\\Users\\Tanvi\\Desktop\\selenium_login_sheet.xls");
			Workbook w;
			w = Workbook.getWorkbook(f);
			Sheet s = w.getSheet(0);
			int rows = s.getRows();
			int columns = s.getColumns();

			inputData = new String[rows][columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					Cell c = s.getCell(j, i);
					inputData[i][j] = c.getContents();
				}
			}
			return inputData;
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (f != null) {
				try {

					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return inputData;
	}
}
