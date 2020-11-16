package com.home.tasl11;

import com.home.core.TreeNode;
import com.home.task11.Task11Solution;
import com.home.task124.Task124Solution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task11SolutionTest {
    private Task11Solution solution;

    @Before
    public void before(){
        this.solution = new Task11Solution();
    }

    @Test
    public void test1() {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int result = 49;
        assertThat(solution.maxArea(input), is(result));
    }

    @Test
    public void test2() {
        int[] input = {1,1};
        int result = 1;
        assertThat(solution.maxArea(input), is(result));
    }

    @Test
    public void test3() {
        int[] input = {4,3,2,1,4};
        int result = 16;
        assertThat(solution.maxArea(input), is(result));
    }

    @Test
    public void test4() {
        int[] input = {1,2,1};
        int result = 2;
        assertThat(solution.maxArea(input), is(result));
    }
}
