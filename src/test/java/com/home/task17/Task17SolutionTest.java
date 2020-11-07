package com.home.task17;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task17SolutionTest {
    private Task17Solution solution;

    @Before
    public void before(){
        this.solution = new Task17Solution();
    }

    @Test
    public void test1() {
        String digits = "23";
        String [] result = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
        assertThat(solution.letterCombinations(digits).toArray(), Matchers.arrayContaining(result));
    }

    @Test
    public void test2() {
        String digits = "";
        String [] result = {};
        assertThat(solution.letterCombinations(digits).toArray().length, is(0));
    }

    @Test
    public void test3() {
        String digits = "2";
        String [] result = {"a","b","c"};
        assertThat(solution.letterCombinations(digits).toArray(), Matchers.arrayContaining(result));
    }
}
