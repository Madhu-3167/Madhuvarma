package com.ExcelOperaions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Multiple_Data {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./src/com/Excel_Operations/Madhu.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("sheet2");
		int rowCount=sheet.getLastRowNum();
        System.out.println(rowCount);
		for(int i=0;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
		 int cellCount=row.getLastCellNum();
		 System.out.println(cellCount);
		 for(int j=0;j<cellCount;j++)
		 {
			String data=row.getCell(j).getStringCellValue();
			System.out.print(data+" ");
		 }
		 System.out.println();
		}
		

	}

}
