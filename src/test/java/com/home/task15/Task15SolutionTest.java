package com.home.task15;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Task15SolutionTest {
    private Task15Solution solution;

    @Before
    public void before(){
        this.solution = new Task15Solution();
    }

    @Test
    public void test1() {
       int[] nums = {-1,0,1,2,-1,-4};
       List<List<Integer>> result= new ArrayList<>();
       result.add(new ArrayList<>(Arrays.asList(-1,-1,2)));
       result.add(new ArrayList<>(Arrays.asList(-1,0,1)));
       assertThat(solution.threeSum(nums), is(equalTo(result)));
    }

   @Test
    public void test2() {
        int[] nums = {};
        assertThat(solution.threeSum(nums), is(empty()));
    }

    @Test
    public void test3() {
        int[] nums = {0};
        assertThat(solution.threeSum(nums), is(empty()));
    }

    @Test
    public void test4() {
        int[] nums = {0,0};
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(0,0,0)));
        assertThat(solution.threeSum(nums),is(empty()));
    }

    @Test
    public void test5() {
        int[] nums = {-1,0,1,0};
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(-1,0,1)));
        assertThat(solution.threeSum(nums),is(empty()));
    }
}
