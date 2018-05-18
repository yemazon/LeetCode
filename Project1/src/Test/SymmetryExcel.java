package Test;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SymmetryExcel {
    public static void main(String[] argv) {

        try {
            String filePath = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/input.xlsx";

            FileInputStream os = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            Sheet sheet = wb.getSheet("Sheet0");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                for (int j = i+1; j < sheet.getLastRowNum(); j++) {
                    try {
                        Row row = sheet.getRow(i);
                        Cell cell = row.getCell(j);
                        String cellValue = cell.getStringCellValue();

                        Row newRow = sheet.getRow(j);
                        Cell newCell = newRow.createCell(i);
                        newCell.setCellValue(cellValue);
                    } catch (NullPointerException e) {
                        System.out.print(i + "+");
                        System.out.print(j + "\n");
                    }

                }
            }

            String outFilePath = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/output.xlsx";
            FileOutputStream out = new FileOutputStream(outFilePath);

            wb.write(out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
