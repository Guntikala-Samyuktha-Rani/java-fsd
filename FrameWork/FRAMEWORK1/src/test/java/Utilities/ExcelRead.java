package Utilities;


import java.io.FileInputStream;





import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;


public class ExcelRead {
  
    HSSFWorkbook file;
    HSSFSheet s;

    public String readExcel(String path,String sheetName, int r, int c) throws Exception {
        FileInputStream fin = new FileInputStream(path);
        file = new HSSFWorkbook(fin);
        s = file.getSheet(sheetName);
        HSSFRow row = s.getRow(r);
        if (row != null) {
            Cell cell = row.getCell(c);
            if (cell != null) {
              
                if (cell.getCellType() == CellType.STRING) {
                	String value = cell.getStringCellValue().trim();
                	return value.isEmpty()? "" : value;
                } else if (cell.getCellType() == CellType.NUMERIC) {
                  return String.valueOf(cell.getNumericCellValue());
                }
            }
        }
		return "";
        
    }
    public  int getLastRow(String path,String sheetName) throws IOException
    {
    	 FileInputStream fin = new FileInputStream(path);
         file = new HSSFWorkbook(fin);
         s = file.getSheet(sheetName);
         if (s != null) {
    	int LastRow= s.getLastRowNum();
    	return LastRow;
    }
         return -1;
    }
    public static void main(String args[]) throws Exception {
        ExcelRead e = new ExcelRead();
        int LastRow = e.getLastRow("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1");
        if (LastRow >=0)
        for ( int i=0;i<=LastRow;i++)
        {
        String Username = e.readExcel("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1", i, 0);
        String Password = e.readExcel("C:\\Users\\hp\\Downloads\\TestData.xls", "Sheet1", i, 1);
       if (!Username.isEmpty() || !Password.isEmpty()) 
        System.out.println("Username"+i+" "+Username);
        System.out.println("Password"+i+" "+Password);
        System.out.println(" ");
    }
}
}




	


