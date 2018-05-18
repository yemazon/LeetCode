package Test;

import java.io.*;
import java.util.Hashtable;

public class GB2312ToUTF8 {
    public static void main(String[] argv) {

        try {
            String pathNameCity = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/city.txt";
            File filenameCity = new File(pathNameCity);
            InputStreamReader readerCity = new InputStreamReader(new FileInputStream(filenameCity), "GB2312");
            BufferedReader brCity = new BufferedReader(readerCity);

            File writeName = new File("/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/cityUTF8.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));

            String lineCity = brCity.readLine();
            while (lineCity != null) {
                String cityChanged = change(lineCity);
                out.write(cityChanged + "\r\n");

                lineCity = brCity.readLine();
            }

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String change (String str1) {
        try {
            byte[] strNew = str1.getBytes("GB2312");
            String Str2 = new String(strNew,"utf-8");
            return Str2;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "wat";
    }
}

