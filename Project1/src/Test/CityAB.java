package Test;

import java.io.*;

public class CityAB {
    public static void main(String[] argv) {
        try {
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/cityUTF8.txt";

            File filename = new File(pathName); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

            File writeName = new File("/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/cityAB.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));


            String line = br.readLine();
            while (line != null) {

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("“");
                stringBuilder.append(line);
                stringBuilder.append("市");
                stringBuilder.append("”");

                out.write(stringBuilder.toString()+"\r\n");
                line = br.readLine();
            }
            br.close();
            out.flush();
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
