package com.home.task85;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task85SolutionTest {
    private Task85Solution solution;

    @Before
    public void before() {
        this.solution = new Task85Solution();
    }

    @Test
    public void test1() {
        char [][] input = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        int result = 6;
        assertThat(solution.maximalRectangle(input), is(result));
    }

    @Test
    public void test2() {
        char [][] input = {};
        int result = 0;
        assertThat(solution.maximalRectangle(input), is(result));
    }

    @Test
    public void test3() {
        char [][] input = {{'0'}};
        int result = 0;
        assertThat(solution.maximalRectangle(input), is(result));
    }

    @Test
    public void test4() {
        char [][] input = {
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}};
        int result = 21;
        assertThat(solution.maximalRectangle(input), is(result));
    }

    @Test
    public void test5() {
        char [][] input = {{'0', '0'}};
        int result = 0;
        assertThat(solution.maximalRectangle(input), is(result));
    }

    @Test
    public void test6() {
        char [][] input = {{'0', '0'}};
        int result = 0;
        assertThat(solution.maximalRectangle(input), is(result));
    }
}
