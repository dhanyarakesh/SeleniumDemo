package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadXLSdata {

@DataProvider(name="data")
public String[][] getData(Method m) throws EncryptedDocumentException, IOException
{
	String excelSheetname=m.getName();
	File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
	//if(f.exists() && !f.isDirectory())
	    //f.delete(); //delete if file already exists.
	//f.createNewFile();

	FileInputStream fis=new FileInputStream(f);
	Workbook wb=WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet SheetName= wb.getSheet(excelSheetname);
	 int totalRows=SheetName.getPhysicalNumberOfRows();
	 System.out.println("total number of rows"+totalRows);
	 Row rowcell=SheetName.getRow(0);
	 int totalcol=rowcell.getPhysicalNumberOfCells();
     System.out.println("total number of columns"+totalcol);
     
     DataFormatter format=new DataFormatter();
     String testData[][]=new String[totalRows][totalcol];
     for(int i=1;i<totalRows;i++)
     {
    	 for(int j=0;j<totalcol;j++)
    	 {
    		 testData[i-1][j]=format.formatCellValue(SheetName.getRow(i).getCell(j));
    	 }
     }
	return testData;
}
}
