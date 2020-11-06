package com.home.task124;

import com.home.core.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task124SolutionTest {
    private Task124Solution solution;

    @Before
    public void before(){
        this.solution = new Task124Solution();
    }

    @Test
    public void test1() {
        TreeNode input = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result = 6;
        assertThat(solution.maxPathSum(input), is(result));
    }

    @Test
    public void test2() {
        TreeNode input = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result = 42;
        assertThat(solution.maxPathSum(input), is(result));
    }

    @Test
    public void test3() {
        TreeNode input = new TreeNode(-3);
        int result = -3;
        assertThat(solution.maxPathSum(input), is(result));
    }

    @Test
    public void test4() {
        TreeNode input = new TreeNode(1, new TreeNode(2), null);
        int result = 3;
        assertThat(solution.maxPathSum(input), is(result));
    }

    @Test
    public void test5() {
        TreeNode input = new TreeNode(1,
                new TreeNode(-2,
                        new TreeNode(1), new TreeNode(3)
                ),
                new TreeNode(-3,
                        new TreeNode(-2, new TreeNode(-1), null),
                        null));
        int result = 3;
        assertThat(solution.maxPathSum(input), is(result));
    }
}
