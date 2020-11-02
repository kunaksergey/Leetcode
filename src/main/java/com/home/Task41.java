package com.home;

import java.util.Arrays;

public class Task41 {
    public static void main(String[] args) {
        Task41 task = new Task41();
        int[] nums = {2, 1};
        System.err.println(task.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }
        int result = 1;
        boolean find = true;
        while (find) {
            int currentValue = result;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == result) {
                    currentValue++;
                    break;
                }
            }
            if (currentValue == result) {
                find = false;
            } else {
                result = currentValue;
            }
        }
        return result;
    }
}
