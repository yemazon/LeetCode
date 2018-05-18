package Houzz;

import java.util.Random;

public class PickRandomInArray {
    private int[] nums;
    private Random rnd;

    public PickRandomInArray(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    public static void main(String[] argv) {
        int[] a = {1,2,3,3,3};
        PickRandomInArray pickRandomInArray = new PickRandomInArray(a);
        System.out.print(pickRandomInArray.pick(3) + "\n");

        Random test = new Random();
        System.out.print(test.nextInt(2));



    }
}
