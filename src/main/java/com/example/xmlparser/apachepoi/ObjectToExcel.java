package com.example.xmlparser.apachepoi;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.example.xmlparser.jaxb.Employee;
import com.example.xmlparser.jaxb.Office;

@Service
public class ObjectToExcel {

	public HSSFWorkbook convert(Office offc) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Office_" + offc.getId());
		
		int rownum = 0;
		int cellnum = 0;
		Row header = sheet.createRow(rownum++);
		for(String attrName: Employee.getAttributeNames()) {
	    	Cell cell = header.createCell(cellnum++);
	        System.out.println(attrName);
	        cell.setCellValue(attrName.toString());
	    }
		
		for (Employee emp: offc.getEmployee()) {
		    Row row = sheet.createRow(rownum++);
		    cellnum = 0;
		    for (Object obj: emp.getAttributes()) {
		        Cell cell = row.createCell(cellnum++);
		        System.out.println(obj);
		        if (obj instanceof Date)
		            cell.setCellValue((Date) obj);
		        else if (obj instanceof Boolean)
		            cell.setCellValue((Boolean) obj);
		        else if (obj instanceof String)
		            cell.setCellValue((String) obj);
		        else if (obj instanceof Double)
		            cell.setCellValue((Double) obj);
		        else if (obj instanceof Integer)
		            cell.setCellValue((Integer) obj);
		    }
		}

		writeToFile("/home/hkothari/assignments/XMLParserAPI/src/main/java/output.xls", workbook);
		return workbook;
	}
	
	private void writeToFile(String filename, HSSFWorkbook workbook) {
		try {
		    FileOutputStream out =
		        new FileOutputStream(new File(filename));
		    workbook.write(out);
		    out.close();
		    System.out.println("Excel written successfully..");
		    

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
