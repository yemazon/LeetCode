package Houzz;

import static java.lang.Character.toUpperCase;

public class ChangeFirstToCap {
    public static void main(String[] argv) {
        System.out.print(changeString("i like houzz"));
    }

    public static String changeString(String input) {
        String[] words = input.split(" ");
        StringBuffer result = new StringBuffer();
        for (String i : words) {
            char[] array = i.toCharArray();
            array[0] = toUpperCase(array[0]);
            result.append(new String(array) + " ");
        }
        return result.toString();
    }
}
