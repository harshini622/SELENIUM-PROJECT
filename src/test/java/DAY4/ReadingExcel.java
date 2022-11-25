package DAY4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel {
	
	@Test
	public void testData() {
		try
        {
            XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\harsm\\Documents\\testread.xlsx")));
            XSSFSheet sh1=wb.getSheet("logindata");
//            XSSFRow r1=sh1.getRow(0);
//            XSSFCell c1=r1.getCell(0);
            int row=sh1.getPhysicalNumberOfRows();
            int col=sh1.getRow(0).getPhysicalNumberOfCells();
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    String value=sh1.getRow(i).getCell(j).getStringCellValue();
                    System.out.println(value);
                }
            }
        }catch(FileNotFoundException e) {
            System.out.println("Path is incorrect");
        }catch(IOException e) {
            System.out.println("unexpected error");
        }
	}
}
