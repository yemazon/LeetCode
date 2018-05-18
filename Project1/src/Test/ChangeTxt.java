package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTxt {




    public static void main(String[] argv) {
        int i = 0;
        List<String> city = new ArrayList<>();
        try {
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/city.txt";
            File filename = new File(pathName); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader( new FileInputStream(filename), "gb2312"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = br.readLine();
            while (line != null) {
                city.add(line);
                line = br.readLine(); // 一次读入一行数据
                i++;
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        i = i-2;
        try {
            /* 写入Txt文件 */
            File writeName = new File("/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/outputAB.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));
            int j = 0;
            int k = 1;
            while (j <= i){
                while (k <= i) {
                    out.write("“" + city.get(j));
                    out.write(city.get(k) + "”" + "\r\n"); // \r\n即为换行

                    k++;
                }
                k = j+2;
                j++;
            }
            out.write(city.get(j-1)); // \r\n即为换行
            out.write(city.get(k-1) + "\r\n");
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
