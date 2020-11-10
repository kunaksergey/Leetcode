package com.home.task70;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task70SolutionTest {
    private Task70Solution solution;

    @Before
    public void before(){
        this.solution = new Task70Solution();
    }

    @Test
    public void test1() {
        int input = 2;
        int result = 2;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test2() {
        int input = 3;
        int result = 3;
        assertThat(solution.climbStairs(input), is(result));
    }
}
