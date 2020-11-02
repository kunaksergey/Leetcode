package com.home;

import java.util.ArrayList;
import java.util.List;

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
//       Output: [1,1,2,3,4,4,5,6]
public class Task23 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] testValues = createTestValues();
        ListNode result = solution.mergeKLists(testValues);
        System.err.println(result);
    }

    private static ListNode[] createTestValues() {
        ListNode[] testArr = new ListNode[3];
        testArr[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        testArr[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        testArr[2] = new ListNode(2, new ListNode(6));
        return testArr;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode headResult = null;
            ListNode tailResult = null;

            boolean find = true;

            while (find) {
                ListNode selectedListNode = null;
                int selectedIndex = -1;
                for (int i = 0; i < lists.length; i++) {
                    ListNode pointer = null;
                    if (lists[i] != null) {
                        pointer = lists[i];
                    }
                    if (pointer == null) {
                        continue;
                    }
                    if (selectedListNode == null) {
                        selectedListNode = pointer;
                        selectedIndex = i;
                        continue;
                    }

                    if (pointer.val < selectedListNode.val) {
                        selectedIndex = i;
                        selectedListNode = pointer;
                    }

                }

                if (selectedIndex != -1) {
                    if (headResult == null) {
                        headResult = selectedListNode;
                        tailResult = selectedListNode;

                    } else {
                        tailResult.next = selectedListNode;
                        tailResult = tailResult.next;
                    }


                    lists[selectedIndex] = selectedListNode.next;
                } else {
                    find = false;
                }
            }

            return headResult;
        }

        private List<ListNode> createPointers(ListNode[] list) {
            List<ListNode> pointers = new ArrayList<>();
            for (int i = 0; i < list.length; i++) {
                ListNode node = list[i];
                if (node != null) {
                    pointers.add(node);
                } else {
                    pointers.add(null);
                }
            }
            return pointers;
        }
    }
}

