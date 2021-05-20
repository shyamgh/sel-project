/**
 * @shyamhushangabadkar
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import selenium_base.Constants;


public class WriteToExcel{

    public static int iterationStart=-1;
    public int startRowNumber=-1;
    public static String iteration;
    public static Map<String, Integer> iterationMap = new HashMap<String, Integer>();


    public void resetIterationRow(){
        iterationStart = -1;
        startRowNumber = -1;
        iterationMap.clear();
    }

    public int getStartRowNumber(String itr) {
        return startRowNumber;
    }

    public void setStartRowNumber(int rowNum) {
        startRowNumber = rowNum;
    }

    public void setRowNumber(Sheet sheet, String [] dataToWrite, int colNumber){
        int lastRowNumber = sheet.getLastRowNum() - sheet.getFirstRowNum();
        if(lastRowNumber != 0){
            lastRowNumber += 1;
        }
        if(iterationStart<0){
            iterationStart = lastRowNumber;
        }

        if ( ! iterationMap.containsKey(dataToWrite[0])){
            iterationMap.put(dataToWrite[0], iterationStart);
            setStartRowNumber(iterationStart);
        }
        else{
            setStartRowNumber(getStartRowNumber(dataToWrite[0])+dataToWrite.length);
        }

    }

    public void writeExcel2(String fileName, String sheetName,String [] dataToWrite) throws IOException {
        String filePath = Constants.Path_TestData;
        File file = new File(filePath + File.separator + fileName );
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

        setRowNumber(sheet, dataToWrite, colNumber);

        String itr = dataToWrite[0];
        Row zeroRowNumber = getRow(sheet ,getStartRowNumber(itr));
        Row  firstRowNumber = getRow(sheet ,getStartRowNumber(itr)+1);
        System.out.println(getStartRowNumber(itr));
        Cell iterationCell = zeroRowNumber.createCell(colNumber);
        iterationCell.setCellValue(dataToWrite[0]);
        Cell loanNumberCell = firstRowNumber.createCell(colNumber);
        loanNumberCell.setCellValue(dataToWrite[1]);

        for(int j = 2; j < dataToWrite.length; j++){
            Row  newRow = getRow(sheet ,getStartRowNumber(itr)+j);
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