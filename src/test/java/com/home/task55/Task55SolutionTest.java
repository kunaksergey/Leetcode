package com.home.task55;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task55SolutionTest {
    private Task55Solution solution;

    @Before
    public void before(){
        this.solution = new Task55Solution();
    }

    @Test
    public void test1() {
        int[] input = {2,3,1,1,4};
        boolean result = true;
        assertThat(solution.canJump(input), is(result));
    }

    @Test
    public void test2() {
        int[] input = {3,2,1,0,4};
        boolean result = false;
        assertThat(solution.canJump(input), is(result));
    }

    @Test
    public void test3() {
        int[] input = {0};
        boolean result = true;
        assertThat(solution.canJump(input), is(result));
    }

    @Test
    public void test4() {
        int[] input = {2,0,0};
        boolean result = true;
        assertThat(solution.canJump(input), is(result));
    }
}
