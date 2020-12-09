package com.home.task148;

import com.home.core.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.home.core.FileReader.readLineByLineJava8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Task148SolutionTest {
    private Task148Solution solution;
    @Before
    public void before() {
        this.solution = new Task148Solution();
    }

    @Test
    public  void test1() {
        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(1,new ListNode(3))));
        int[] result = new int[] {1,2,3,4};
        assertThat(convertToArray(solution.sortList(listNode)), is(equalTo(result)));
    }

    @Test
    public  void test2() {
        ListNode listNode = null;
        ListNode result = null;
        assertThat(solution.sortList(listNode), is(result));
    }


    @Test
    public  void test3() {
        ListNode listNode = new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(1))));
        int[] result = new int[] {1,2,3,4};
        assertThat(convertToArray(solution.sortList(listNode)), is(equalTo(result)));
    }

    @Test
    public  void test4() {
        String inputStr = readLineByLineJava8("E:\\LeetcodeGit\\src\\test\\java\\com\\home\\task148\\input").trim();
        String resultStr = readLineByLineJava8("E:\\LeetcodeGit\\src\\test\\java\\com\\home\\task148\\result").trim();
        ListNode listNode = convertToListNode(inputStr);
        ListNode result = convertToListNode(resultStr);

        assertThat(convertToArray(solution.sortList(listNode)), is(equalTo(convertToArray(result))));
    }

    private ListNode convertToListNode(String str) {
        List<Integer> collect = Arrays.stream(str.split(",")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i <collect.size() ; i++) {
            ListNode node = new ListNode(collect.get(i));
            if(head==null){
                head = node;
                current = node;
            }else {
                current.next = node;
                current = current.next;
            }

        }
        return head;
    }

    private int[] convertToArray(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode!=null){
            list.add(currentNode.val);
            currentNode= currentNode.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
