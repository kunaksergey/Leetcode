package com.home.task121;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task121SolutionTest {
    private Task121Solution solution;

    @Before
    public void before(){
        this.solution = new Task121Solution();
    }

    @Test
    public void test1() {
        int[] input = {7,1,5,3,6,4};
        int result = 5;
        assertThat(solution.maxProfit(input), is(result));
    }

    @Test
    public void test2() {
        int[] input = {7,6,4,3,1};
        int result = 0;
        assertThat(solution.maxProfit(input), is(result));
    }
}
