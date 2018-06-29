package com.tyss.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public static String  getExcelData(String sheet,int row,int column)throws Exception, Exception, IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("D:\\Practise\\EventReport1\\TestData\\StudentDetails.xls");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet(sheet);
Row rw=sh.getRow(row);
String value=rw.getCell(column).getStringCellValue();
System.out.println(value);
return value;
	}

}
