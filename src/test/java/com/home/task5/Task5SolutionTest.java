package com.home.task5;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// 5. Longest Palindromic Substring
public class Task5SolutionTest {
    private Task5Solution solution;

    @Before
    public void before(){
        this.solution = new Task5Solution();
    }

    @Test
    public void test1() {
       String input = "babad";
       String result = "bab";
       String result1 = "aba";

       assertThat(solution.longestPalindrome(input), anyOf(is(equalTo(result)), is(equalTo(result1))));
    }

    @Test
    public void test2() {
        String input = "a";
        String result = "a";
        assertThat(solution.longestPalindrome(input), is(equalTo(result)));
    }

    @Test
    public void test3() {
        String input = "ac";
        String result = "a";
        assertThat(solution.longestPalindrome(input), is(equalTo(result)));
    }

    @Test
    public void test4() {
        String input = "cbbd";
        String result = "bb";
        assertThat(solution.longestPalindrome(input), is(equalTo(result)));
    }
}
