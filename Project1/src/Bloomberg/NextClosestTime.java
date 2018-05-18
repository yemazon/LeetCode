package Bloomberg;

import java.util.Arrays;
import java.util.HashMap;

public class NextClosestTime {
    public static void main(String[] argv) {
        System.out.print(next("11:00"));

    }

    public static String next(String time) {
        char[] chars = time.toCharArray();

        int[] chart = {1234,1243,1324,1342,1423,1432,2134,2143,2314,2341,2413,2431,3124,3142,3214,3241,3412,3421,4123,4132,4213,4231,4312,4321};
        boolean resultFlag = false;
        int a = (int) chars[0];
        int b = (int) chars[1];
        int c = (int) chars[3];
        int d = (int) chars[4];
        boolean[] flag = {false,false,false,false};

        int[] temp = {a,b,c,d};
        Arrays.sort(temp);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : temp) {
            if(i == a && !flag[0]) {
                flag[0] = true;
                stringBuilder.append(1);
            }
            if(i == b && !flag[1]) {
                flag[1] = true;
                stringBuilder.append(2);
            }
            if(i == c && !flag[2]) {
                flag[2] = true;
                stringBuilder.append(3);
            }
            if(i == d && !flag[3]) {
                flag[3] = true;
                stringBuilder.append(4);
            }
        }
        int pos = Integer.parseInt(stringBuilder.toString());


        for (int i = 0;i< chart.length;i++) {
            int num = getNum(time,chart[i]);
            if (chart[i] == pos && !resultFlag) {
                resultFlag = true;
                continue;
            }
            if (resultFlag && judge(num)) {
                return change(num);
            }
        }
        return change(getNum(time, chart[0]));
    }

    private static boolean judge(int num) {
        int a = num/1000;
        int b = (num - a * 1000)/100;
        int c = (num-a*1000-b*100) / 10;
        int d = (num-a*1000-b*100 - c * 10);
        int hour = a*10 + b;
        int minute = c*10 + d;

        return (hour < 24 && minute < 60);
    }
    private static String change(int num) {
        int a = num/1000;
        int b = (num - a * 1000)/100;
        int c = (num-a*1000-b*100) / 10;
        int d = (num-a*1000-b*100 - c * 10);
        int hour = a*10 + b;
        int minute = c*10 + d;

        return hour + ":" + minute;
    }

    public static int getNum(String input, int num) {

        int a = num/1000;
        int b = (num - a * 1000)/100;
        int c = (num-a*1000-b*100) / 10;
        int d = (num-a*1000-b*100 - c * 10);

        StringBuilder stringBuilder = new StringBuilder();
        if(a == 1) stringBuilder.append(input.charAt(0));
        if(b == 1) stringBuilder.append(input.charAt(0));
        if(c == 1) stringBuilder.append(input.charAt(0));
        if(d == 1) stringBuilder.append(input.charAt(0));
        if(a == 2) stringBuilder.append(input.charAt(1));
        if(b == 2) stringBuilder.append(input.charAt(1));
        if(c == 2) stringBuilder.append(input.charAt(1));
        if(d == 2) stringBuilder.append(input.charAt(1));
        if(a == 3) stringBuilder.append(input.charAt(3));
        if(b == 3) stringBuilder.append(input.charAt(3));
        if(c == 3) stringBuilder.append(input.charAt(3));
        if(d == 3) stringBuilder.append(input.charAt(3));
        if(a == 4) stringBuilder.append(input.charAt(4));
        if(b == 4) stringBuilder.append(input.charAt(4));
        if(c == 4) stringBuilder.append(input.charAt(4));
        if(d == 4) stringBuilder.append(input.charAt(4));

        return Integer.parseInt(stringBuilder.toString());
    }
}
