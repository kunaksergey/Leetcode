package com.home.task39;

import java.util.*;
import java.util.stream.Collectors;
// 39. Combination Sum
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

    private List<List<Integer>> handler(int[] candidates, int target){
        List<Summary> result = new ArrayList<>();
        for (int i = 0; i <candidates.length ; i++) {
            Candidate candidate = new Candidate(candidates[i],candidates, target);
            result.addAll(candidate.combinationSum());
        }

        return new ArrayList<>(result
                .stream()
                .map(summary -> {
                    Collections.sort(summary.combinationList);
                   return summary.combinationList;})
                .collect(Collectors.toSet()));
    }

    private class Candidate {
        private int candidate;
        private int[] source;
        private int target;
        public Candidate(int candidate, int[] source, int target) {
            this.candidate = candidate;
            this.source = source;
            this.target = target;
        }

        public  List<Summary> combinationSum() {
            List<Summary> result = new ArrayList<>();
            List<Summary> summaryList= new ArrayList<>(Arrays.asList(new Summary(candidate)));

            while (summaryList.size()!=0 ){
                List<Summary> newSummaryList= new ArrayList<>();
                for (int i = 0; i <summaryList.size() ; i++) {
                    Summary oldSumamry = summaryList.get(i);
                    for (int j = 0; j < source.length ; j++) {
                        Summary newSummary = new Summary(oldSumamry);
                        newSummary.add(source[j]);
                        int summ = newSummary.sum();
                        if(summ==target) {
                            result.add(newSummary);
                        }else if(summ<target){
                            newSummaryList.add(newSummary);
                        }
                    }
                }
                summaryList = newSummaryList;
             }
            return result;
        }
    }

    private class Summary{
        List<Integer> combinationList;
        {
        combinationList = new ArrayList<>();
        }

        public Summary(int value) {
            this.combinationList.add(value);
        }

        public Summary(Summary summary) {
            this.combinationList.addAll(summary.combinationList);
        }

        void add(int value){
            combinationList.add(value);
        }

        int sum() {
            int sum = 0;
            for (int i = 0; i < combinationList.size() ; i++) {
                sum+= combinationList.get(i);
            }
            return sum;
        }
    }
}
