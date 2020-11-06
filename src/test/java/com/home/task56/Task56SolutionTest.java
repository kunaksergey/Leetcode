package com.home.task56;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Task56SolutionTest {
    private Task56Solution solution;

    @Before
    public void before(){
        this.solution = new Task56Solution();
    }

    @Test
    public void test1() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = {{1,6},{8,10},{15,18}};
        assertThat(solution.merge(input), is(equalTo(result)));
    }

    @Test
    public void test2() {
        int[][] input = {{1,4},{4,5}};
        int[][] result = {{1,5}};
        assertThat(solution.merge(input), is(equalTo(result)));
    }
}
