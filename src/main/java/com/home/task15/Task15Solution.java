package com.home.task15;

import java.util.*;
// 3Sum
public class Task15Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        //find non negative index
        int nonNegativeIndex = -1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>=0){
                nonNegativeIndex = i;
                break;
            }
        }

        if(nonNegativeIndex==-1){
            return new ArrayList<>();
        }

        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>0){
                continue;
            }
            for (int j = 0; j <nums.length ; j++) {
                if(nums[i]+nums[j]>0){
                    continue;
                }
                if(i==j) continue;
                for (int k = nonNegativeIndex; k<nums.length ; k++) {
                    if(nums[k]<0){
                        continue;
                    }
                    if(j==k) continue;
                    if((nums[i]+nums[j]+nums[k])==0) {
                        List<Integer> list = new ArrayList<>();
                        int summ = nums[i]+nums[j]+nums[k];
                        int min = Math.min(nums[i],Math.min(nums[j],nums[k]));
                        int max = Math.max(nums[i],Math.max(nums[j],nums[k]));
                        int middle = summ - (min+max);
                        list.add(min);
                        list.add(middle);
                        list.add(max);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
