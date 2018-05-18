package leetcode;

public class Solution256 {

        public int minCost(int[][] costs) {
            if (costs == null || costs.length == 0) {
                return 0;
            } else if (costs.length == 1) {
                return Math.min(Math.min(costs[0][0], costs[0][1]),costs[0][2]);
            } else {
                return Math.min(Math.min(minium(costs,costs[0][0], 0), minium(costs, costs[0][1],1)), minium(costs,costs[0][2],2));
            }
        }

        public int minium(int[][] costs, int input, int flag) {
            for (int i = 1; i < costs.length; i++) {
                if (flag == 0) {
                    if (costs[i][1] < costs[i][2]) {
                        flag = 1;
                        input += costs[i][1];
                    } else {
                        flag = 2;
                        input += costs[i][2];
                    }
                } else if (flag == 1) {
                    if (costs[i][0] < costs[i][2]) {
                        flag = 0;
                        input += costs[i][0];
                    } else {
                        flag = 2;
                        input += costs[i][2];
                    }
                } else {
                    if (costs[i][0] < costs[i][1]) {
                        flag = 0;
                        input += costs[i][0];
                    } else {
                        flag = 1;
                        input += costs[i][1];
                    }
                }
            }
            return input;
        }

}
