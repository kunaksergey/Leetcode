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
        int input = 1;
        int result = 1;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test2() {
        int input = 2;
        int result = 2;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test3() {
        int input = 3;
        int result = 3;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test4() {
        int input = 4;
        int result = 5;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test6() {
        int input = 5;
        int result = 8;
        assertThat(solution.climbStairs(input), is(result));
    }

    @Test
    public void test7() {
        int input = 6;
        int result = 13;
        assertThat(solution.climbStairs(input), is(result));
    }
}
