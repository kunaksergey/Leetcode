package com.home.task141;

import com.home.core.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task141SolutionTest {
    private Task141Solution solution;

    @Before
    public void before(){
        this.solution = new Task141Solution();
    }

    @Test
    public void test1() {
        ListNode cycle = new ListNode(2);
        ListNode tail = new ListNode(-4,cycle);
        ListNode input = new ListNode(3,cycle);
        cycle.next = new ListNode(0,tail);
        boolean result = true;
        assertThat(solution.hasCycle(input), is(result));
    }

    @Test
    public void test2() {
        ListNode input = new ListNode(1);
        ListNode  tail = new ListNode(2,input);
        input.next = tail;
        boolean result = true;
        assertThat(solution.hasCycle(input), is(result));
    }

    @Test
    public void test3() {
        ListNode input = new ListNode(1);
        boolean result = false;
        assertThat(solution.hasCycle(input), is(result));
    }

    @Test
    public void test4() {
        ListNode input = new ListNode(1,new ListNode(2));
        boolean result = false;
        assertThat(solution.hasCycle(input), is(result));
    }
}
