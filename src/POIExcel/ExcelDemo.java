package POIExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	public ExcelDemo(String Path, String SheetName) throws Exception {
		
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method to get row count
	public  int getRowCount() {
		return ExcelWSheet.getPhysicalNumberOfRows();
	}
	
	//Method to get data for all columsn of given index
	public  void getExcelData(int index) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		Iterator<Row> iterator = ExcelWSheet.iterator();
		iterator.next();
		while(iterator.hasNext())
		{
			arrayList.add(iterator.next().getCell(index).getStringCellValue());
		}
		System.out.println(arrayList);
 	}
	
	 //This method to get the data and get the value as strings.
	   public String getCellDataasstring(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         String CellData =
	            ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	         System.out.println("The value of CellData " + CellData);
	         return CellData;
	      } catch (Exception e) {
	         return "Errors in Getting Cell Data";
	      }
	   }
	   
	   //This method to get the data and get the value as number.
	   public double getCellDataasnumber(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         double CellData =
	            ExcelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
	         System.out.println("The value of CellData " + CellData);
	         return CellData;
	      } catch (Exception e) {
	         return 000.00;
	      }
	   }
	public static void main(String[] args) throws Exception {
		ExcelDemo eu = new ExcelDemo("C:\\Users\\rgajul\\eclipse-workspace\\SeleniumPractise\\src\\TestData\\TestData.xlsx", "Sheet1");
		eu.getExcelData(0);
		eu.getExcelData(1);
		eu.getExcelData(2);
		eu.getCellDataasstring(0,0);
			
	}
}
