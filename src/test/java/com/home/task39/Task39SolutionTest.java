package com.home.task39;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class Task39SolutionTest {
    private Task39Solution solution;

    @Before
    public void before(){
        this.solution = new Task39Solution();
    }

    @Test
    public void test1() {
        int [] input = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(2,2,3)));
        result.add(new ArrayList<>(Arrays.asList(7)));
        assertThat(solution.combinationSum(input, target), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void test2() {
        int [] input = {2,3,5};
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(2,2,2,2)));
        result.add(new ArrayList<>(Arrays.asList(2,3,3)));
        result.add(new ArrayList<>(Arrays.asList(3,5)));
        assertThat(solution.combinationSum(input, target), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void test3() {
        int [] input = {2};
        int target = 1;
        List<List<Integer>> result = new ArrayList<>();
        assertThat(solution.combinationSum(input, target), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void test4() {
        int [] input = {1};
        int target = 2;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1,1)));
        assertThat(solution.combinationSum(input, target), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void test5() {
        int [] input = {1};
        int target = 1;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        assertThat(solution.combinationSum(input, target), containsInAnyOrder(result.toArray()));
    }
}
