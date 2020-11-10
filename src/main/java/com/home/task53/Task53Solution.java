package com.home.task53;

//53. Maximum Subarray
public class Task53Solution {
    public int maxSubArray(int[] nums) {
        int summ = nums[0];
        int max = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>0){
                if(summ>0){
                    summ = summ+nums[i];
                }else{
                    summ = nums[i];
                }
            }else{
                max = Math.max(max,summ);
                max = Math.max(max,nums[i]);
                summ+=nums[i];
            }
        }
        return Math.max(max,summ);
    }
}
