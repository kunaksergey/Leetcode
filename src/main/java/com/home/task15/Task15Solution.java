package com.home.task15;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// 3Sum
public class Task15Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        nums = trim(nums,3);

        int changePoint = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>=0 && changePoint== Integer.MIN_VALUE){
                changePoint = i;
            }
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        if(changePoint==Integer.MIN_VALUE) {
            return new ArrayList<>();
        }

        int maxRightValue = Math.abs(2*min);
        int maxLeftValue = -1 * Math.abs(2*max);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int j = 0; j <=changePoint ; j++) {
            int leftValue = nums[j];
            if(leftValue<maxLeftValue) continue;
            for (int k = changePoint; k <nums.length ; k++) {
                if(j==k) continue;
                int rightValue = nums[k];
                if(rightValue > maxRightValue) continue;

                int summFirstSecond= nums[j]+nums[k];
                if(!map.containsKey(summFirstSecond)){
                    map.put(summFirstSecond,new ArrayList<>());
                }
                List<int[]> summInfoList = map.get(summFirstSecond);
                int[] summInfo = {j,k,leftValue,rightValue,Integer.MIN_VALUE};
                summInfoList.add(summInfo);
            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for (int j = 0; j <nums.length ; j++) {
            int valueForFinding = 0-nums[j];
            if(map.containsKey(valueForFinding)){
                List<int[]> lists = map.get(valueForFinding);
                for(int[] list: lists){
                    if(list[0]==j || list[1]==j) {
                        continue;
                    }
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(list[2],list[3], nums[j]));
                    Collections.sort(tmp);
                    result.add(tmp);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private int[] trim(int [] nums, int countDigits){
        int [] arr = new int[nums.length];
        if(arr.length < countDigits ) return new int[0];
        for (int i = 0; i <countDigits ; i++) {
            arr[i] = nums[i];
        }

        if(arr.length == countDigits ) return arr;
        int index =countDigits;
        for (int i = countDigits; i <nums.length ; i++) {
            if(nums[i]==nums[i-countDigits]){
                continue;
            }else{
                arr[index] = nums[i];
                index++;
            }
        }
        int[] result = new int[index];
        System.arraycopy(arr,0, result,0, index);
        return result;
    }
}
