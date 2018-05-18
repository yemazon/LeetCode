package Test;

import java.io.*;

public class TestRead {
    public static void main(String[] argv) {
        try {
            String pathName = "/Users/Sure/Documents/GitHub/LeetCode/Project1/src/Test/output.txt";
            File file = new File(pathName);
            InputStream input = new FileInputStream(file);
            StringBuffer buffer = new StringBuffer();
            byte[] bytes = new byte[1024];
            for(int n ; (n = input.read(bytes))!=-1 ; ){
                buffer.append(new String(bytes,0,n));
            }
            String result = buffer.toString();
            for (int i = 0;i<1;i++) {
                System.out.print(getEncoding(result));
                String another = utf8Togb2312(result);
                System.out.print(getEncoding(another));
                System.out.print(another);
            }
        }
        catch (Exception e) {
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

    public static String utf8Togb2312(String str){
        StringBuffer sb = new StringBuffer();
        for ( int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+' :
                    sb.append( ' ' );
                    break ;
                case '%' :
                    try {
                        sb.append(( char )Integer.parseInt (
                                str.substring(i+1,i+3),16));
                    }
                    catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                    i += 2;
                    break ;
                default :
                    sb.append(c);
                    break ;
            }
        }
        String result = sb.toString();
        String res= null ;
        try {
            byte [] inputBytes = result.getBytes( "8859_1" );
            res= new String(inputBytes, "UTF-8" );
        }
        catch (Exception e){}
        return res;
    }

}
