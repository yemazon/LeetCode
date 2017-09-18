package com;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abcdcba";
        int i = 0;
        int j = s.length()-1;

        while (s.charAt(i) == s.charAt(j) && i < j) {
            System.out.println(i);
            i++;
            j--;
        }
        String testA = s.substring(0,i) + s.substring(i+1,s.length());
        String testB = s.substring(0,j) + s.substring(j+1,s.length());

        if (isPalindrome(testA) || isPalindrome(testB) || testA.length() == 1 || testB.length() == 1) {
            System.out.println("true");
        }
        System.out.println("false");
    }

    public static boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
