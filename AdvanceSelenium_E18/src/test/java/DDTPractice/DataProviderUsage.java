package DDTPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;

public class DataProviderUsage {

	@Test(dataProvider = "getData")
	public void testCase(String firstName,String lastName)
	{
		System.out.println("Firstname "+firstName+" LastName "+lastName);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] objArr=new Object[3][2];
		
		ExcelFileUtility ex=new ExcelFileUtility();
		
		objArr[0][0]=ex.readingDataFromExcel("DDT", 2, 0);
		objArr[0][1]=ex.readingDataFromExcel("DDT",2, 1);
		objArr[1][0]=ex.readingDataFromExcel("DDT", 3, 0);
		objArr[1][1]=ex.readingDataFromExcel("DDT",3, 1);
		objArr[2][0]=ex.readingDataFromExcel("DDT", 4, 0);
		objArr[2][1]=ex.readingDataFromExcel("DDT",4, 1);
		System.out.println(objArr);
		
		
		return objArr;
	}
}
