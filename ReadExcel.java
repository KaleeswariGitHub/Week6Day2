package week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData(String filename) throws IOException 
	{
	 
	XSSFWorkbook wb= new XSSFWorkbook("./data/ServiceNow.xlsx");
	
	XSSFSheet ws = wb.getSheet("User_Id");
	
	int rowNum = ws.getLastRowNum();
	
	int colNum = ws.getRow(0).getLastCellNum();
	String[][] value = new String[rowNum][colNum];
	
	for(int i=1;i<=rowNum;i++)
	{
		for(int j=0;j<colNum;j++)
		{
			XSSFRow row= ws.getRow(i);
			XSSFCell col = row.getCell(j);
			String cellValue = col.getStringCellValue();
			System.out.println(cellValue);
			value[i-1][j]= cellValue; 
			
		}
	}
	
	wb.close();
	return value;
	
	}
}


