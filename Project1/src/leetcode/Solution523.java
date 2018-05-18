package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            list.add(count);
        }
//        while (list.size() > 0) {
//            if (list.contains(k)) {
//                return true;
//            } else {
//
//                for (Integer i : list) {
//
//                }
//            }
//
//        }
        return false;
    }
}
