package com.home.task62;


import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task62SolutionTest {
    private Task62Solution solution;

    @Before
    public void before(){
        this.solution = new Task62Solution();
    }

    @Test
    public void test1() {
        int [] input = {3,2};
        int result = 3;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }

    @Test
    public void test2() {
        int [] input = {7,3};
        int result = 28;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }

    @Test
    public void test3() {
        int [] input = {3,7};
        int result = 28;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }

    @Test
    public void test4() {
        int [] input = {3,3};
        int result = 6;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }

    @Test
    public void test5() {
        int [] input = {23,12};
        int result = 193536720;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }

    @Test
    public void test6() {
        int [] input = {51,9};
        int result = 1916797311;
        assertThat(solution.uniquePaths(input[0],input[1]), is(result));
    }
}
