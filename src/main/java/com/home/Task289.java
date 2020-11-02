package com.home;

import java.util.Arrays;

public class Task289 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.findDuplicate(new int[] {1,4,3,2,4}));

    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            int [] tmp = new int[nums.length+1];

            for (int i = 0; i <nums.length ; i++) {
                if(tmp[nums[i]]!=0){
                    return nums[i];
                }else{
                    tmp[nums[i]] =nums[i];
                }
            }
           return nums[0];
        }
    }
}
