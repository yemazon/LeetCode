package Viagogo;

public class FindHoleInSortedArray {


    //[0,1,2,3,5,6,7]
    //[2,3,5,6,7]
    //[1,2,3,4]
    //[0,1,2,3]
    //[0,3]
    public int solve(int[] input) {
        if (input == null || input.length <= 1 || input[input.length-1] - input[0] > input.length) {
            return -1;
        }

        if (input[input.length-1] == input[0] + input.length - 1) {
            if (input[0] == 0) {
                return input[input.length-1] + 1;
            } else {
                return 0;
            }
        }
        int start = 0;
        int end = input.length - 1;

        while(start + 1 < end) {
            int mid = input[(end + start) / 2];
            if (mid == input[0] + (end + start) / 2) {
                start = (end + start) / 2;
            } else {
                end = (end + start) / 2;
            }
        }
        return input[start] + 1;
    }
}
