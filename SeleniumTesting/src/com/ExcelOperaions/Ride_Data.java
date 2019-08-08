package com.ExcelOperaions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ride_Data {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);
		cell.setCellValue("Madhuvarma");
		FileOutputStream file1=new FileOutputStream("./src/com/Excel_Operations/Madhu.xlsx");
		workbook.write(file1);
	}

}
