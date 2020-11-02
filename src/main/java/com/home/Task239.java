package com.home;

import java.util.Arrays;

public class Task239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] testData = new int [] {1,3,-1,-3,5,3,6,7};
        System.err.println("length: " + testData.length);
        System.err.println(Arrays.toString(solution.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));

    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int [] result = new int[nums.length-k+1];
            int max = Integer.MIN_VALUE;
            int prevMax = Integer.MIN_VALUE;
            boolean firstStep = true;
            for (int i = 0; i < nums.length-k+1 ; i++) {
                if(firstStep){
                    prevMax = max = nums[0];
                    for (int j = 1; j <k ; j++) {
                        if(nums[j]>max){
                            prevMax = max;
                            max = nums[j];
                        }
                    }
                   firstStep = false;
                    result[0] = max;
                }else{
                    if(max == nums[i-1]){
                        max = prevMax;
                    }
                }
            }

            return result;
        }

    }
}
