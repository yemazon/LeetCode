package Test;

import java.io.*;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TxtToExcel {
    public static void main(String[] argv) {
        Hashtable<String, Integer> cityIndex = new Hashtable<>();
        int rowNum = 1;
        try {
            String filePath = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/template.xlsx";

            String pathNameCity = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/city0503UTF.txt";

            FileOutputStream os = new FileOutputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();
            Row row = sheet.createRow(0);

            //这一段读入的city.txt是GB2312编码的，因为要保存excel的第0行和第0列，输出为中文
            File filenameCity = new File(pathNameCity);
            InputStreamReader readerCity = new InputStreamReader(new FileInputStream(filenameCity));
            BufferedReader brCity = new BufferedReader(readerCity);

            String lineCity = brCity.readLine();

            Cell cell = row.createCell(rowNum);
            cell.setCellValue(lineCity);
            Row newRow = sheet.createRow(rowNum);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(lineCity);

            while (lineCity != null) {

                lineCity = brCity.readLine();

                rowNum++;
                cell = row.createCell(rowNum);
                cell.setCellValue(lineCity);

                newRow = sheet.createRow(rowNum);
                newCell = newRow.createCell(0);
                newCell.setCellValue(lineCity);
            }
            readerCity.close();
            brCity.close();

            // CMD  iconv -c -f GB2312 -t UTF-8 a.txt >> aUTF.txt
            // 读入UTF-8格式城市列表做一个HashTable

            String pathNameCityUTF = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/city0503UTF.txt";
            File filenameCityUTF = new File(pathNameCityUTF);
            InputStreamReader readerCityUTF = new InputStreamReader(new FileInputStream(filenameCityUTF), "UTF-8");
            BufferedReader brCityUTF = new BufferedReader(readerCityUTF);
            String lineCityUTF = brCityUTF.readLine();
            int index = 1;

            while (lineCityUTF != null) {
                cityIndex.put(lineCityUTF, index);
                index++;
                lineCityUTF = brCityUTF.readLine();
            }
            brCityUTF.close();
            readerCityUTF.close();


            //从结果文件读入数据，一次读一行，空格分离 A+B 和 cell value
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/0503UTF.txt";

            File filename = new File(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            String[] value;
            String[] city;

            while (line != null) {

                value = line.split(" ");
                city = value[0].split("\\+");

                if (cityIndex.get(city[0]) == null) {
                    line = br.readLine();
                    continue;
                }

                newRow = sheet.getRow(cityIndex.get(city[0]));

                if (cityIndex.get(city[1]) == null) {
                    line = br.readLine();
                    continue;

                }

                newCell = newRow.createCell(cityIndex.get(city[1]));
                newCell.setCellValue(value[1]);

                line = br.readLine();
            }
            reader.close();
            br.close();
//
////------------------------------后面为测试用
//
//            pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/result22.txt";
//
//            filename = new File(pathName);
//            reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
//            br = new BufferedReader(reader);
//            line1 = br.readLine();
//            line2 = br.readLine();
//
//            while (line1 != null && line2 != null) {
//                try {
//                    city = line1.split("\\+");
//                    newRow = sheet.getRow(cityIndex.get(city[0]));
//                    newCell = newRow.getCell(cityIndex.get(city[1]));
//                    String temp = newCell.getStringCellValue();
//                    newCell.setCellValue(getBig(temp,line2));
//                } catch (NullPointerException e) {
//                    System.out.print(line1 + "\n");
//                } finally {
//                    line1 = br.readLine();
//                    line2 = br.readLine();
//                }
//            }
//            pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/result33.txt";
//
//            filename = new File(pathName);
//            reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
//            br = new BufferedReader(reader);
//            line1 = br.readLine();
//            line2 = br.readLine();
//
//            while (line1 != null && line2 != null) {
//                try {
//                    city = line1.split("\\+");
//                    newRow = sheet.getRow(cityIndex.get(city[0]));
//                    newCell = newRow.getCell(cityIndex.get(city[1]));
//                    String temp = newCell.getStringCellValue();
//                    newCell.setCellValue(getBig(temp,line2));
//                } catch (NullPointerException e) {
//                    System.out.print(line1 + "\n");
//                } finally {
//                    line1 = br.readLine();
//                    line2 = br.readLine();
//                }
//            }
//            pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/result44.txt";
//
//            filename = new File(pathName);
//            reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
//            br = new BufferedReader(reader);
//            line1 = br.readLine();
//            line2 = br.readLine();
//
//            while (line1 != null && line2 != null) {
//                try {
//                    city = line1.split("\\+");
//                    newRow = sheet.getRow(cityIndex.get(city[0]));
//                    newCell = newRow.getCell(cityIndex.get(city[1]));
//                    String temp = newCell.getStringCellValue();
//                    newCell.setCellValue(getBig(temp,line2));
//                } catch (NullPointerException e) {
//                    System.out.print(line1 + "\n");
//                } finally {
//                    line1 = br.readLine();
//                    line2 = br.readLine();
//                }
//            }

//------------------------------之前为测试用*/

            wb.write(os);
            os.flush();
            os.close();
//---------------------------------------------------------------------------------------------------

//            String eFilePath = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/template.xlsx";String eOutFilePath = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/output.xlsx";
//
//            FileInputStream eIn = new FileInputStream(eFilePath);
//            XSSFWorkbook eInwb = new XSSFWorkbook(eIn);
//            eIn.close();
//            Sheet eSheet = eInwb.getSheet("Sheet0");
//
//            //从结果文件读入数据，一次读两行，第一行用来找两个hash，第二行为cell value
//            String excelName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/utf1.txt";
//
//            File eFilename = new File(excelName);
//            InputStreamReader eReader = new InputStreamReader(new FileInputStream(eFilename), "UTF-8");
//            BufferedReader ebr = new BufferedReader(eReader);
//            String eLine1 = ebr.readLine();
//            String eLine2 = ebr.readLine();
//            String[] eCity;
//            Row mRow;
//            Cell mCell;
//            while (eLine1 != null && eLine2 != null) {
//                eCity = eLine1.split("\\+");
//
//                mRow = eSheet.getRow(cityIndex.get(eCity[0]));
//                mCell = mRow.getCell(cityIndex.get(eCity[1]));
//                String temp = mCell.getStringCellValue();
//
//                mCell.setCellValue(getBig(temp,eLine2));
//
//                eLine1 = ebr.readLine();
//                eLine2 = ebr.readLine();
//            }
//
//            FileOutputStream excelFileOutPutStream = new FileOutputStream(eFilePath);
//            eInwb.write(excelFileOutPutStream);
//            excelFileOutPutStream.flush();
//            excelFileOutPutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getBig(String a, String b) {
        if (a.equals("") && b.equals("")) {
            return "0";
        }
        if (a.equals("") || a.equals("0")) {
            return b;
        }
        if (b.equals("") || b.equals("0")) {
            return a;
        }

        long aToNum = Integer.parseInt(a);
        long bToNum = Integer.parseInt(b);
        if (aToNum > bToNum) {
            return a;
        }
        else {
            return b;
        }
    }

}