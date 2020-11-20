package com.home.task39;

import java.util.*;
import java.util.stream.Collectors;
// 39. Combination Sum
public class Task39Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> candidatesSet = Arrays.stream(candidates).boxed().collect(Collectors.toSet());
        Set<List<Integer>> decomposedTargetSet = decomposeTarget(target);
        for (List<Integer> list: decomposedTargetSet){
            if(candidatesSet.containsAll(list)){
                result.add(list);
            }
        }
        return result;
    }

    private Set<List<Integer>> decomposeTarget(int target) {
        Set<List<Integer>> decomposedTargetSet = new HashSet<>();
        decompose(target, decomposedTargetSet);
        decomposedTargetSet.add(new ArrayList<>(Arrays.asList(target)));
        return decomposedTargetSet;
    }

    private void decompose(int target, Set<List<Integer>> decomposedTargetSet) {
        for (int i = 1; i < target; i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(target - i, i));
            Collections.sort(list);
            decomposedTargetSet.add(list);
        }

        Set<List<Integer>> decomposedSet = new HashSet<>();
        for (List<Integer> list: decomposedTargetSet) {
            for (int j = 0; j < list.size(); j++) {
                int value = list.get(j);
                Set<List<Integer>> decomposedValueSet = new HashSet<>();
                List<Integer> copyofList = new ArrayList<>(list);
                copyofList.remove(j);
                decompose(value, decomposedValueSet);
                for (List<Integer> tmpList: decomposedValueSet) {
                    tmpList.addAll(copyofList);
                    Collections.sort(tmpList);
                }
                decomposedSet.addAll(decomposedValueSet);

            }

        }
        decomposedTargetSet.addAll(decomposedSet);
    }
}
