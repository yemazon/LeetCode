import java.util.HashMap;
import java.util.HashSet;

/**
 * 532 K-diff Pairs in an Array
 *
 * Given an array of integers and an integer k, you need to find the number
 * of unique k-diff pairs in the array. Here a k-diff pair is defined as an
 * integer pair (i, j), where i and j are both numbers in the array and their
 * absolute difference is k.

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.
 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).
 Note:
 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KdiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        if (nums.length<=0 || k < 0) {
            return 0;
        }

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) < 2) {
                    count ++;
                    map.put(nums[i],map.get(nums[i])+1);
                    if (k != 0) {
                        if (!set.contains(nums[i]+k)) {
                            map.put(nums[i]+k,0);
                        }
                        if (!set.contains(nums[i]-k)) {
                            map.put(nums[i]-k,0);
                        }
                    }
                }
                else{
                    continue;
                }
            }
            else {
                if (!set.contains(nums[i]+k)) {
                    map.put(nums[i]+k,0);
                }
                if (!set.contains(nums[i]-k)) {
                    map.put(nums[i]-k,0);
                }
            }
            set.add(nums[i]);
        }
        return count;
    }
    public static int find(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        if (nums.length<=0 || k < 0) {
            return 0;
        }

        for (int i=0;i<nums.length;i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                if (map.containsKey(nums[i])) {
                    count = count + map.get(nums[i]);

                }
                else {
                    if (!set.contains(nums[i]+k)) {
                        map.put(nums[i]+k,0);
                    }
                    if (!set.contains(nums[i]-k)) {
                        map.put(nums[i]-k,0);
                    }
                }
            }
            else {
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,2,1};
        int k = 1;

        int result = findPairs(test, k);
        System.out.println(result);

    }

}
