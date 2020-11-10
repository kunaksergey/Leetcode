package com.home.task22;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Task22SolutionTest {
    private Task22Solution solution;

    @Before
    public void before(){
        this.solution = new Task22Solution();
    }

    @Test
    public void test1() {
        int input = 3;
        List<String> result = new ArrayList<>(Arrays.asList("((()))","(()())","(())()","()(())","()()()"));
        assertThat(solution.generateParenthesis(input),containsInAnyOrder(result.toArray()));
    }

    @Test
    public void test2() {
        int input = 1;
        List<String> result = new ArrayList<>();
        result.add("()");
        assertThat(solution.generateParenthesis(input).toArray(), Matchers.arrayContaining(result.toArray()));
    }


}
