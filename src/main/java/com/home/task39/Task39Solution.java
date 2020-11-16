package com.home.task39;

import java.util.*;

public class Task39Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] ints = Arrays.stream(candidates).filter(c -> c != target).toArray();
        if(candidates.length!=ints.length){
            result.add(new ArrayList<>(Arrays.asList(target)));
        }
        result.addAll(handler(ints, target));

        return result;
    }

    List<List<Integer>> handler(int[] candidates, int target){
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i <candidates.length ; i++) {
            Candidate candidate = new Candidate(candidates[i],candidates, target);
            result.addAll(candidate.combinationSum());
        }
        return new ArrayList<>(result);
    }

    private class Candidate {
        private int candidate;
        private int[] candidates;
        private int target;
        public Candidate(int candidate, int[] candidates, int target) {
            this.candidate = candidate;
            this.candidates = candidates;
            this.target = target;
        }

        public Collection<? extends List<Integer>> combinationSum() {
            List<List<Integer>> result= new ArrayList<>();

            return result;
        }
    }
}
