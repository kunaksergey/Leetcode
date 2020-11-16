package com.home.task78;

import java.util.*;

// 78. Subsets
public class Task78Solution {

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(new ArrayList<>());
        for (int i = 0; i <nums.length ; i++) {
            Set<List<Integer>> newSubsets = new HashSet<>();
            for (List<Integer>list: subsets) {
                for (int k = 0; k <nums.length ; k++) {
                    int currentValue = nums[k];
                    if(list.contains(currentValue)) continue;
                    if(list.size()==0) {
                        newSubsets.add(Arrays.asList(currentValue));
                    }else{
                        newSubsets.addAll(leftRigthtCombination(currentValue, list));
                    }
                }
            }
            subsets.addAll(newSubsets);
        }
        return new ArrayList<>(subsets);
    }

    private Set<List<Integer>> leftRigthtCombination(int value, List<Integer> list){
        Set<List<Integer>> combination = new HashSet<>();
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        //add to left
        newList.add(0,value);
        Collections.sort(newList);
        combination.add(newList);
        newList = new ArrayList<>();
        //add to right
        newList.add(value);
        Collections.sort(newList);
        combination.add(newList);
        return combination;
    }
}

