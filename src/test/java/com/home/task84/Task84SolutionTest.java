package com.home.task84;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task84SolutionTest {
    private Task84Solution solution;

    @Before
    public void before(){
        this.solution = new Task84Solution();
    }


    @Test
    public void test1() {
        int [] input = {2,1,5,6,2,3};
        int result = 10;
        assertThat(solution.largestRectangleArea(input), is(result));
    }

    @Test
    public void test2() {
        int [] input = {};
        int result = 0;
        assertThat(solution.largestRectangleArea(input), is(result));
    }

    @Test
    public void test3() {
        int [] input = {1};
        int result = 1;
        assertThat(solution.largestRectangleArea(input), is(result));
    }

    @Test
    public void test4() {
        int [] input = {0,0,0,0,0,0,0,0,2147483647};
        int result = 2147483647;
        assertThat(solution.largestRectangleArea(input), is(result));
    }


}
