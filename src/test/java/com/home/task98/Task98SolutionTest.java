package com.home.task98;

import com.home.core.TreeNode;
import com.home.task94.Task94Solution;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Task98SolutionTest {
    private Task98Solution solution;

    @Before
    public void before() {
        this.solution = new Task98Solution();
    }


    @Test
    public void test1() {
        TreeNode input = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result = true;
        assertThat(solution.isValidBST(input), is(equalTo(result)));
    }

    @Test
    public void test2() {
        TreeNode input = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean result = false;
        assertThat(solution.isValidBST(input), is(equalTo(result)));
    }

    @Test
    public void test3() {
        TreeNode input = new TreeNode(5, new TreeNode(-1), null);
        boolean result = true;
        assertThat(solution.isValidBST(input), is(equalTo(result)));
    }

    @Test
    public void test4() {
        TreeNode input = new TreeNode(10, new TreeNode(5), new TreeNode(15,  new TreeNode(6), new TreeNode(20)));
        boolean result = false;
        assertThat(solution.isValidBST(input), is(equalTo(result)));
    }

    @Test
    public void test5() {
        TreeNode input = new TreeNode(5, new TreeNode(14, new TreeNode(1), null),null);
        boolean result = false;
        assertThat(solution.isValidBST(input), is(equalTo(result)));
    }
}
