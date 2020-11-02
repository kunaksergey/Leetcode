package com.home;

import java.util.Arrays;

public class Task283 {
    public static void main(String[] args) {
        Task283 task = new Task283();
//        int[] nums = {0,1,0,3,12};
        int[] nums = {1};
        task.moveZeroes(nums);
        System.err.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int tmpIndex=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0){
                nums[tmpIndex] = nums[i];
                if(tmpIndex!=i) {
                    nums[i] = 0;
                }
                tmpIndex++;

            }
        }
    }
}
