package hems.app_utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Component
public class ExcelWriter {

    public void writeIntoExcel(String s) {
    	
    	String[] sArray=s.split("\\d+");
    	
    	 // Creating file object of existing excel file
        File xlsxFile = new File("C:\\Users\\batta.chowdary\\Documents\\SampleForProject.xlsx");
         
        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);
             
            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheetAt(0);
 
            //Getting the count of existing records
            int rowCount = sheet.getLastRowNum();
 
            //for numbering in excel
            int i=0;
            //Iterating new students to update
            for (String someRandomText : sArray) {
                 
                //Creating new row from the next row count
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
               
                Cell cell1 = row.createCell(columnCount++);
                cell1.setCellValue(++i);
                Cell cell2 = row.createCell(columnCount++);
                if (someRandomText instanceof String) {
                	
                    cell2.setCellValue((String) someRandomText);
                }
                
            }
            //Close input stream
            inputStream.close();
 
            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);
             
            //Close the workbook and output stream
            workbook.close();
            os.close();
             
            System.out.println("Excel file has been updated successfully.");
             
        } catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
    }



    



    
}
