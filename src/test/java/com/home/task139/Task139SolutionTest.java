package com.home.task139;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task139SolutionTest {
    private Task139Solution solution;

    @Before
    public void before(){
        this.solution = new Task139Solution();
    }

    @Test
    public void test1() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result = false;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test4() {
        String s = "a";
        List<String> wordDict = new ArrayList<>();
        boolean result = false;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test5() {
        String s = "bb";
        List<String> wordDict =  Arrays.asList("bb","a","b","bbb","bbbb");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test6() {
        String s = "aaaaaaa";
        List<String> wordDict =  Arrays.asList("aaaa","aaa");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test7() {
        String s = "abcd";
        List<String> wordDict =  Arrays.asList("a","abc","b","cd");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test8() {
        String s = "ccbb";
        List<String> wordDict =  Arrays.asList("bc","cb");
        boolean result = false;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test9() {
        String s = "ccaccc";
        List<String> wordDict =  Arrays.asList("cc","ac");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }

    @Test
    public void test10() {
        String s = "aaaaaaaa";
        List<String> wordDict =  Arrays.asList("aaaa","aaa","aa");
        boolean result = true;
        assertThat(solution.wordBreak(s,wordDict), is(result));
    }
}
