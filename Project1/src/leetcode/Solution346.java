package leetcode;

public class Solution346 {

    private final int size;
    private int lastUsedIndex;
    private int[] window;
    private double sum;
    private int count;

        /** Initialize your data structure here. */
        public Solution346(int size) {
            this.size = size;
            this.window = new int[size];
            this.lastUsedIndex = 0;
            this.sum = 0d;
            this.count = 0;
        }

        public double next(int val) {

            if (this.count < size) {
                this.count ++;
            }

            if (lastUsedIndex == window.length) {
                sum = sum - window[0] + val;
                lastUsedIndex = 0;
                window[lastUsedIndex] = val;
                lastUsedIndex ++;
            } else {
                sum = sum - window[lastUsedIndex] + val;
                window[lastUsedIndex] = val;
                lastUsedIndex ++;
            }

            return sum / count;
        }

        public int getLastUsedIndex() {
            return this.lastUsedIndex;
        }

    public double getSum() {
        return this.sum;
    }

    public int getCount() {
        return count;
    }


}
