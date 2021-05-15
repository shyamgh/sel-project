package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteToExcel{

    public int startRowNumber;

    public int getStartRowNumber() {
        return startRowNumber;
    }

    public void setStartRowNumber(int rowNum) {
        startRowNumber = rowNum;
    }

    public static void main(String[] args) throws IOException {
        /*writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-1", "LN:12345", "file1", "file2", "file3", "file4"});
        writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-2", "LN:12345","file1", "file2", "file3", "file4",
                        "file1", "file2", "file3"});
        writeExcel2("data.xls", "Sheet1",
                new String[]{"Iteration-3", "LN:12345", "file1", "file2", "file3", "file4",
                        "file1", "file2", "file3", "file1", "file2"});*/
    }

    public void writeExcel2(String fileName, String sheetName,String [] dataToWrite) throws IOException {
        String filePath = "D:\\Development\\Selenium Project\\";
        File file = new File(filePath+ fileName );
        FileInputStream inputStream = new FileInputStream(file);

        Workbook wb1 = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            wb1 = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            wb1 = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = wb1.getSheet(sheetName);
        int colNumber = Integer.parseInt(dataToWrite[0].split("-")[1])-1;
        if (colNumber == 0) {
            int lastRowNumber = sheet.getLastRowNum() - sheet.getFirstRowNum();
            setStartRowNumber(lastRowNumber);
        }

        Row zeroRowNumber = getRow(sheet ,getStartRowNumber());
        Row  firstRowNumber = getRow(sheet ,getStartRowNumber()+1);
        System.out.println(getStartRowNumber());
        Cell iterationCell = zeroRowNumber.createCell(colNumber);
        iterationCell.setCellValue(dataToWrite[0]);
        Cell loanNumberCell = firstRowNumber.createCell(colNumber);
        loanNumberCell.setCellValue(dataToWrite[1]);

        for(int j = 2; j < dataToWrite.length; j++){
            Row  newRow = getRow(sheet ,getStartRowNumber()+j);
            Cell cell = newRow.createCell(colNumber);
            cell.setCellValue(dataToWrite[j]);
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        wb1.write(outputStream);
        outputStream.close();
    }

    private static Row getRow(Sheet sheet,int rowNumber) {
        Row row = null;
        try {
            row = sheet.getRow(rowNumber);
        } catch (NullPointerException e) {
            row = sheet.createRow(rowNumber);
        } finally {
            if (row == null){
                row = sheet.createRow(rowNumber);
            }
        }
        return row;
    }
}