package com.home.task438;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task438SolutionTest {
    private Task438Solution solution;

    @Before
    public void before(){
        this.solution = new Task438Solution();
    }

    @Test
    public void test1() {
        String input = "cbaebabacd";
        String world = "abc";
        List<Integer> result = Arrays.asList(0, 6);
        assertTrue(solution.findAnagrams(input,world).equals(result));
    }

    @Test
    public void test2() {
        String input = "abab";
        String world = "ab";
        List<Integer> result = Arrays.asList(0, 1, 2);
        assertTrue(solution.findAnagrams(input,world).equals(result));
    }
}


