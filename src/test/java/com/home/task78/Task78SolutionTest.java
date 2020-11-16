package com.home.task78;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class Task78SolutionTest {
    private Task78Solution solution;

    @Before
    public void before(){
        this.solution = new Task78Solution();
    }


    @Test
    public void test1() {
        int [] input = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>(Arrays.asList(1)));
        result.add(new ArrayList<>(Arrays.asList(2)));
        result.add(new ArrayList<>(Arrays.asList(1,2)));
        result.add(new ArrayList<>(Arrays.asList(3)));
        result.add(new ArrayList<>(Arrays.asList(1,3)));
        result.add(new ArrayList<>(Arrays.asList(2,3)));
        result.add(new ArrayList<>(Arrays.asList(1,2,3)));
        assertThat(solution.subsets(input),  containsInAnyOrder(result.toArray()));
    }


}
