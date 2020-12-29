package com.home.task221;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task221SolutionTest {
    private Task221Solution solution;

    @Before
    public void before(){
        this.solution = new Task221Solution();
    }

    @Test
    public void test1() {
        char[][] input =  {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int result = 4;
        assertThat(solution.maximalSquare(input), is(result));
    }

    @Test
    public void test2() {
        char[][] input =  {{'0','1'},{'1','0'}};
        int result = 1;
        assertThat(solution.maximalSquare(input), is(result));
    }

    @Test
    public void test3() {
        char[][] input =  {{'0'}};
        int result = 0;
        assertThat(solution.maximalSquare(input), is(result));
    }

    @Test
    public void test4() {
        char[][] input =  {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        int result = 9;
        assertThat(solution.maximalSquare(input), is(result));
    }
}
