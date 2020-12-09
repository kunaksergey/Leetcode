package com.home.task94;

import com.home.core.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Task94SolutionTest {
    private Task94Solution solution;

    @Before
    public void before() {
        this.solution = new Task94Solution();
    }


    @Test
    public void test1() {
        TreeNode input = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 3, 2));
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }

    @Test
    public void test2() {
        TreeNode input = null;
        List<Integer> result = new ArrayList<>();
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }

    @Test
    public void test3() {
        TreeNode input = new TreeNode(1);
        List<Integer> result = new ArrayList<>(Arrays.asList(1));
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }

    @Test
    public void test4() {
        TreeNode input = new TreeNode(1, null, new TreeNode(2));
        List<Integer> result = new ArrayList<>(Arrays.asList(1,2));
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }

    @Test
    public void test5() {
        TreeNode input = new TreeNode(1, new TreeNode(2), null);
        List<Integer> result = new ArrayList<>(Arrays.asList(2,1));
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }

    @Test
    public void test6() {
        TreeNode input = new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        List<Integer> result = new ArrayList<>(Arrays.asList(1,3,2));
        assertThat(solution.inorderTraversal(input), is(equalTo(result)));
    }
}
