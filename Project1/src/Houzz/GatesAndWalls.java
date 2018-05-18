package Houzz;

import java.util.ArrayList;
import java.util.List;

public class GatesAndWalls {
    public void main(String[] argv) {


    }

    private Boolean getWays(char[][] input) {
        return null;
    }

    private Boolean checkAround(int[][] location) {
        return null;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i != val) {
                list.add(i);
                count++;
            }
        }

        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        return array.length;
    }
}
