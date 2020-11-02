package com.home.task3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

import org.junit.Before;
import org.junit.Test;

public class Task3SolutionTest {
    private Task3Solution solution;

    @Before
    public void before(){
       this.solution = new Task3Solution();
    }

    @Test
    public void test1() {
        String s = "abcabcbb";
        int result = 3;
        assertThat(solution.lengthOfLongestSubstring(s), comparesEqualTo(result));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        int result = 1;
        assertThat(solution.lengthOfLongestSubstring(s), comparesEqualTo(result));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        int result = 3;
        assertThat(solution.lengthOfLongestSubstring(s), comparesEqualTo(result));
    }

    @Test
    public void test4() {
        String  s = "";
        int result = 0;
        assertThat(solution.lengthOfLongestSubstring(s), comparesEqualTo(result));
    }

    @Test
    public void test5() {
        String  s= "au";
        int result = 2;
        assertThat(solution.lengthOfLongestSubstring(s), comparesEqualTo(result));
    }

}
