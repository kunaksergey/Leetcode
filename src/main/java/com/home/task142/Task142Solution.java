package com.home.task142;

import com.home.core.ListNode;

import java.util.HashSet;
import java.util.Set;

// 142. Linked List Cycle II
public class Task142Solution {

    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;

        Set<ListNode> set = new HashSet<>();
        set.add(head);
        ListNode currentNode = head.next;
        while (currentNode!=null){
            if(set.contains(currentNode)){
                return currentNode;
            }else{
                set.add(currentNode);
            }
            currentNode = currentNode.next;
        }
        return null;
    }
}
