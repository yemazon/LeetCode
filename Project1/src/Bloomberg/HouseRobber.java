package Bloomberg;

public class HouseRobber {
    public static void main(String[] argv) {
//       int[] a = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
//        System.out.print(rob(a));


    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return nums[0]>nums[1] ? nums[0] : nums[1];
        }
        else if (nums.length == 3) {
            return (nums[0]+nums[2]) > nums[1] ? (nums[0]+nums[2]) : nums[1];
        }
        else {
            int[] first = new int[nums.length-2];
            for (int i=0;i<nums.length-2;i++) {
                first[i] = nums[i+2];
            }
            int[] second = new int[nums.length-3];
            for (int i=0;i<nums.length-3;i++) {
                second[i] = nums[i+3];
            }

            return ((nums[0]+ rob(first)) > (nums[1] + rob(second))) ? (nums[0]+ rob(first)) :(nums[1] + rob(second)) ;
        }

    }
}
