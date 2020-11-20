package com.home.task64;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task64SolutionTest {
    private Task64Solution solution;

    @Before
    public void before(){
        this.solution = new Task64Solution();
    }

    @Test
    public void test1() {
        int [][] input = {{1,3,1},{1,5,1},{4,2,1}};
        int result = 7;
        assertThat(solution.minPathSum(input), is(result));
    }

    @Test
    public void test2() {
        int [][] input = {{1,2,3},{4,5,6}};
        int result = 12;
        assertThat(solution.minPathSum(input), is(result));
    }
}
