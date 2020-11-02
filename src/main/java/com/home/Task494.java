package com.home;

public class Task494 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));

    }

    static class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int count= 0;
            for (int i = 0; i <nums.length ; i++) {
                int summ = 0;
                for (int j = 0; j <nums.length ; j++) {
                    if(i==j){
                     summ = summ+nums[j]*-1;
                    }else{
                        summ = summ+nums[j];
                    }

                }
                if(summ == S){
                    count++;
                }
            }
            return count;
        }
    }
}
