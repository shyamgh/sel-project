/**
 * @shyamhushangabadkar
 */
package utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;
    private static int HeaderRowNumber = 0;

    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        //Create an object of File class to open xls file
        File file = new File(excelFilePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        workbook = new HSSFWorkbook(inputStream);

        //creating a Sheet object
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNumber, int colNum) {
        //getting the cell value from rowNumber and column Number
        cell = sheet.getRow(rowNumber).getCell(colNum);

        //returning the cell value as string
        return cell.getStringCellValue();
    }

    public String getCellData(int rowNumber, String columnName) {
        //getting the cell value from rowNumber and column Name
        int colNum = getColumnNumber(columnName);
        return getCellData(rowNumber, colNum);
    }

    public int getRowCountInSheet() {
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        return rowcount;
    }

    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        //creating a new cell in row and setting value to it
        sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
    }

    public List<String> getHeaders(){
        List<String> headers = new ArrayList<String>();
        int columns = sheet.getRow(HeaderRowNumber).getPhysicalNumberOfCells();
        for(int i=0; i<columns;i++) {
            headers.add(getCellData(HeaderRowNumber, i));
        }
        return headers;
    }

    public int getColumnNumber(String columnName){
        int columns = sheet.getRow(HeaderRowNumber).getPhysicalNumberOfCells();
        for(int i=0; i<columns;i++) {
            if(getCellData(HeaderRowNumber, i).equals(columnName))
                return i;
        }
        return -1;
    }
}