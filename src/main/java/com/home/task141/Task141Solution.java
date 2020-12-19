package com.home.task141;

import com.home.core.ListNode;

import java.util.HashSet;
import java.util.Set;

// 141. Linked List Cycle
public class Task141Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;

        Set<ListNode> set = new HashSet<>();
        set.add(head);
        ListNode currentNode = head.next;
        while (currentNode!=null){
            if(set.contains(currentNode)){
                return true;
            }else{
                set.add(currentNode);
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}
