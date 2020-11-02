package com.home;

import java.util.ArrayList;
import java.util.List;

public class Task448 {
    public static void main(String[] args) {
        Task448 task448 = new Task448();
        int [] nums = {4,3,2,7,8,2,3,1};
        System.err.println(task448.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] tmp = new boolean [nums.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            tmp[nums[i]-1] = true;
        }
        for (int i = 0; i <tmp.length ; i++) {
            if(tmp[i]==false){
                result.add(i+1);
            }

        }
        return result;
    }
}
