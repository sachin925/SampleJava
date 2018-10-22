package common;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	private FileInputStream fis;
	private int totalRow;
	public ExcelRead(File src) {
		try {
			fis = new FileInputStream(src);
            workBook = new XSSFWorkbook();
            workBook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSheetnum(int sheetnum){
		sheet = workBook.getSheetAt(sheetnum);
	}
	public int rowCount(){
		totalRow = sheet.getLastRowNum();
		return totalRow;
	}
	public int colCount(){
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String getData(int row, int col){
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

    public static void main(String arg[]){
	    File file = new File("C:\\myProjects\\SampleJava\\common\\data.xls");
	    ExcelRead obj = new ExcelRead(file);
	    obj.setSheetnum(0);
	    System.out.println(obj.getData(0,0));
    }

}