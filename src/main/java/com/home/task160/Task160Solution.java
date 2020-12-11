package com.home.task160;

import com.home.core.ListNode;

import java.util.ArrayList;
import java.util.List;
// 160. Intersection of Two Linked Lists
public class Task160Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();

        ListNode node = headA;

        while (node != null) {
            list.add(node);
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (list.contains(node)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

}


//    If the two linked lists have no intersection at all, return null.
//        The linked lists must retain their original structure after the function returns.
//        You may assume there are no cycles anywhere in the entire linked structure.
//        Each value on each linked list is in the range [1, 10^9].
//        Your code should preferably run in O(n) time and use only O(1) memory.
