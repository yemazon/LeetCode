package Test;

import java.io.*;
import java.util.HashMap;


public class ArrangeTxt {

    public static void main(String[] argv) {
        HashMap<String, String> cityList = new HashMap<>();
        try {
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/input.txt";

            File filename = new File(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String line1 = br.readLine();
            String line2 = br.readLine();
            System.out.print(line1 + "\n");
            System.out.print(line2 + "\n");
            while (line1 != null && line2 != null) {
                cityList.put(line1, line2);
                line1 = br.readLine();
                line2 = br.readLine();
            }

//            byte[] bytes1 = new byte[1024];
//            int n1 = input.read(bytes1);
//            buffer1.append(new String(bytes1,0,n1,"UTF-8"));
//
//            byte[] bytes2 = new byte[1024];
//            StringBuffer buffer2 = new StringBuffer();
//            int n2 = input.read(bytes2);
//            buffer2.append(new String(bytes2,0,n2));
//
//            cityList.put(buffer1.toString(),buffer2.toString());
//            System.out.print(buffer2.toString());
//            while(n1 !=-1 ) {
//                buffer1 = new StringBuffer();
//                buffer2 = new StringBuffer();
//                bytes1 = new byte[1024];
//                bytes2 = new byte[1024];
//                n1 = input.read(bytes1);
//                n2 = input.read(bytes2);
//                if (n1 != -1 && n2 != -1) {
//                    buffer1.append(new String(bytes1, 0, n1, "UTF-8"));
//                    buffer2.append(new String(bytes2, 0, n2));
//                    cityList.put(buffer1.toString(), buffer2.toString());
//                }
//            }
            //System.out.print(buffer1.toString());
            //System.out.print(buffer2.toString());
            //System.out.print(cityList.get(buffer1.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/city.txt";
            File filename = new File(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            String line4 = br.readLine();
            System.out.print(line1+"+"+line4);

            System.out.print(cityList.get(line1+"+"+line2));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }
}
