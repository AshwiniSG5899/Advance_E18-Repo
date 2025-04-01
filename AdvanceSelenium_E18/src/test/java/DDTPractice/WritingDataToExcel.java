package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\QSP-Ashtra\\practice\\AdvanceSelenium_E18\\src\\test\\resources\\TestScriptData_E18.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        //wb.createSheet("WriteData").createRow(1).createCell(2).setCellValue("Selenium");
        wb.getSheet("DDT").createRow(2).createCell(0).setCellValue(2000);
        FileOutputStream fos=new FileOutputStream("C:\\Users\\QSP-Ashtra\\practice\\AdvanceSelenium_E18\\src\\test\\resources\\TestScriptData_E18.xlsx");
        wb.write(fos);
        wb.close();
        System.out.println("Data written successfully");
	}

}
