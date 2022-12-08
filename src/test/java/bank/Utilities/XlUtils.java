package bank.Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        book = new XSSFWorkbook(fi);
        sheet = book.getSheet(xlSheet);
        int rowCount = sheet.getLastRowNum();
        book.close();
        fi.close();
        return rowCount;
    }
    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        fi = new FileInputStream(xlFile);
        book = new XSSFWorkbook(fi);
        sheet = book.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        book.close();
        fi.close();
        return cellCount;
    }
    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlFile);
        book = new XSSFWorkbook(fi);
        sheet = book.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            String celldata = formatter.formatCellValue(cell); // Return the formatted value of the cell as String regardless of the cell type.
            return celldata;
        }
        catch(Exception e) {
            data ="";
        }
        book.close();
        fi.close();
        return data;
    }

    public void setCellData1(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
        fi = new FileInputStream(xlFile);
        book = new XSSFWorkbook(fi);
        sheet = book.getSheet(xlSheet);
        row = sheet.getRow(rowNum);
        cell = row.createCell(colNum);
        cell.setCellValue(data);

        fo = new FileOutputStream(xlFile);
        book.write(fo);
        book.close();
        fi.close();
        fo.close();
    }




}
