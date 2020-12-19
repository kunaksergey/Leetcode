package com.home.task142;

import com.home.core.ListNode;
import com.home.task141.Task141Solution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task142SolutionTest {
    private Task142Solution solution;

    @Before
    public void before(){
        this.solution = new Task142Solution();
    }

    @Test
    public void test1() {
        ListNode cycle = new ListNode(2);
        ListNode tail = new ListNode(-4,cycle);
        ListNode input = new ListNode(3,cycle);
        cycle.next = new ListNode(0,tail);
        ListNode result = cycle;
        assertThat(solution.detectCycle(input), is(result));
    }

    @Test
    public void test2() {
        ListNode input = new ListNode(1);
        ListNode  tail = new ListNode(2,input);
        input.next = tail;
        ListNode result = input;
        assertThat(solution.detectCycle(input), is(result));
    }

    @Test
    public void test3() {
        ListNode input = new ListNode(1);
        ListNode result = null;
        assertThat(solution.detectCycle(input), is(result));
    }

    @Test
    public void test4() {
        ListNode input = new ListNode(1,new ListNode(2));
        ListNode result = null;
        assertThat(solution.detectCycle(input), is(result));
    }
}
