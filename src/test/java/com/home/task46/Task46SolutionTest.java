package com.home.task46;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class Task46SolutionTest {
    private Task46Solution solution;

    @Before
    public void before(){
        this.solution = new Task46Solution();
    }

    @Test
    public void test1() {
        int [] input = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(3,2,1));
        result.add(Arrays.asList(2,3,1));
        result.add(Arrays.asList(2,1,3));
        result.add(Arrays.asList(3,1,2));
        result.add(Arrays.asList(1,3,2));
        result.add(Arrays.asList(1,2,3));
        assertThat(solution.permute(input).toArray(), Matchers.arrayContaining(result.toArray()));
    }

}
