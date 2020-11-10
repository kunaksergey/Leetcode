package com.home.task53;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Task53SolutionTest {
    private Task53Solution solution;

    @Before
    public void before(){
        this.solution = new Task53Solution();
    }

    @Test
    public void test1() {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        int result = 6;
        assertThat(solution.maxSubArray(input), is(equalTo(result)));
    }

    @Test
    public void test2() {
        int[] input = {1};
        int result = 1;
        assertThat(solution.maxSubArray(input), is(equalTo(result)));
    }

    @Test
    public void test3() {
        int[] input = {0};
        int result = 0;
        assertThat(solution.maxSubArray(input), is(equalTo(result)));
    }

    @Test
    public void test4() {
        int[] input = {-1};
        int result = -1;
        assertThat(solution.maxSubArray(input), is(equalTo(result)));
    }

    @Test
    public void test5() {
        int[] input = {-2,-1};
        int result = -1;
        assertThat(solution.maxSubArray(input), is(equalTo(result)));
    }
}
