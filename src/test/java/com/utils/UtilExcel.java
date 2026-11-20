package com.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {
    public static String SHEET_Path = System.getProperty("user.dir") + "/src/test/java/com/utils/UtilExcel.java";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getDataFromExcel(String sheetName) {

        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(SHEET_Path);
            book = WorkbookFactory.create(inputStream);
            sheet = book.getSheet(sheetName);

        } catch (IOException e) {
            System.out.println("File not found");
        }

        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                // First row email, password -> column name - skip - header
                data[i][j]= sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}