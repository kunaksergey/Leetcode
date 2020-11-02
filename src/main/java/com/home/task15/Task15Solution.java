package com.home.task15;

import java.util.*;
// 3Sum
public class Task15Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums.length<3){
            return new ArrayList<>();
        }

        Set<List<Integer>> result = new HashSet<>();
        int newNums [] = new int[nums.length];

        //find non negative index
        int negativeIndex = -1;
        int nonNegativeIndex = -1;

        for (int i = 0; i <nums.length ; i++) {
            int newIndex = -1;
            if(nums[i]>=0) {
                if(nonNegativeIndex == -1) {
                    nonNegativeIndex = nums.length -1;
                }else{
                    nonNegativeIndex--;
                }
                newIndex = nonNegativeIndex;
            }else{
                if(negativeIndex==-1){
                    negativeIndex = 0;
                } else {
                    negativeIndex++;
                }
                newIndex = negativeIndex;
            }
            newNums[newIndex] = nums[i];
        }

        if(nonNegativeIndex==-1){
            return new ArrayList<>();
        }

        for (int i = 0; i <newNums.length ; i++) {
            if(newNums[i]>0){
                continue;
            }
            for (int j = i+1; j <newNums.length ; j++) {
                if(newNums[i]+newNums[j]>0){
                    continue;
                }
                if(i==j) continue;
                for (int k = nonNegativeIndex; k<newNums.length ; k++) {
                    if(newNums[k]<0){
                        continue;
                    }
                    if(i==k || j==k) continue;
                    if((newNums[i]+newNums[j]+newNums[k])==0) {
                        List<Integer> list = new ArrayList<>();
                        int summ = newNums[i]+newNums[j]+newNums[k];
                        int min = Math.min(newNums[i],Math.min(newNums[j],newNums[k]));
                        int max = Math.max(newNums[i],Math.max(newNums[j],newNums[k]));
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
