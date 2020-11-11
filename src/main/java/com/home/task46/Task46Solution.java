package com.home.task46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 46. Permutations
public class Task46Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(nums[0])));
        for (int i = 1; i < nums.length; i++) {
            int currentValue = nums[i];
            final int size = i;
            List<List<Integer>> filteredListList = result.stream().filter(list -> list.size() == size).collect(Collectors.toList());
            for (List<Integer> filteredList : filteredListList) {
                result.addAll(permute(filteredList, currentValue));
            }
        }
        return result.stream().filter(list -> list.size() == nums.length).collect(Collectors.toList());
    }

    private List<List<Integer>> permute(List<Integer> filteredList, int currentValue) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= filteredList.size(); i++) {
            List<Integer> list = new ArrayList<>(filteredList);
            list.add(i, currentValue);
            result.add(list);
        }
        return result;
    }
}
