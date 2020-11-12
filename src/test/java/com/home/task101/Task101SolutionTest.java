package com.home.task101;

import com.home.core.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task101SolutionTest {
    private Task101Solution solution;

    @Before
    public void before(){
        this.solution = new Task101Solution();
    }

    @Test
    public void test1() {
        TreeNode input = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        boolean result = true;
        assertThat(solution.isSymmetric(input), is(result));
    }

    @Test
    public void test2() {
        TreeNode input =  new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        boolean result = false;
        assertThat(solution.isSymmetric(input), is(result));
    }
}
