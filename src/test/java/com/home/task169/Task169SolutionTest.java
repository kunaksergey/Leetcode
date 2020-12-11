package com.home.task169;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task169SolutionTest {
    private Task169Solution solution;

    @Before
    public void before(){
        this.solution = new Task169Solution();
    }

    @Test
    public void test1() {
        int[] input = {3,2,3};
        int result = 3;
        assertThat(solution.majorityElement(input), is(result));
    }

    @Test
    public void test2() {
        int[] input = {2,2,1,1,1,2,2};
        int result = 2;
        assertThat(solution.majorityElement(input), is(result));
    }
}
