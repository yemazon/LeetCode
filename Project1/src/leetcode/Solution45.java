package leetcode;

public class Solution45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return getMin(nums, 0, 0);
    }

    public int getMin(int[] nums, int pos, int step) {
        if (pos + nums[pos] >= nums.length-1 || pos + 1 == nums.length-1) {
            return step + 1;
        }
        if (nums[pos] == 0) {
            return getMin(nums, pos+1, step+1);
        }
        return Math.min(getMin(nums, pos+1, step+1), getMin(nums, pos+nums[pos],step+1));
    }
}
