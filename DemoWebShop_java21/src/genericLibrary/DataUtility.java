package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	public String getDataFromProperties(String key) throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream("./TestData/Data1 (2).xlsx");
		Properties pobj = new Properties();
		
		try {
			pobj.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = pobj.getProperty(key);
		return value;
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh =book.getSheet(sheetName);
		
		String value=sh.getRow(rowNum).getCell(cellNum).toString();
		return value;
		
	}
}
