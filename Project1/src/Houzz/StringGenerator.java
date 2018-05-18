package Houzz;

public class StringGenerator {
    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789%$&#";
        char[] rands = new char[8];
        for (int i = 0; i < rands.length; i++)
        {
            int rand = (int) (Math.random() * a.length());
            rands[i] = a.charAt(rand);
        }
        for(int i=0;i<rands.length;i++){
            System.out.println(rands[i]);
        }
    }
}
