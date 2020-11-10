package com.home.task32;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Task32SolutionTest {
    private Task32Solution solution;

    @Before
    public void before(){
        this.solution = new Task32Solution();
    }

    @Test
    public void test1() {
        String input = "(()";
        int result = 2;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }

    @Test
    public void test2() {
        String input = ")()())";
        int result = 4;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }

    @Test
    public void test3() {
        String input = "";
        int result = 0;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }

    @Test
    public void test4() {
        String input = "()(())";
        int result = 6;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }

    @Test
    public void test5() {
        String input = ")(";
        int result = 0;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }

    @Test
    public void test6() {
        String input = "()(()";
        int result = 0;
        assertThat(solution.longestValidParentheses(input),is(equalTo(result)));
    }
}
