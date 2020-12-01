package com.home.task148;

import com.home.core.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 148. Sort List
public class Task148Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode!=null){
            list.add(currentNode);
            ListNode previous = currentNode;
            currentNode= currentNode.next;
            previous.next = null;
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.val< o2.val) return -1;
            if(o1.val> o2.val) return 1;
            return 0;
        });

        head = list.get(0);
        currentNode = head;
        for (int i = 1; i <list.size() ; i++) {
            currentNode.next = list.get(i);
            currentNode = currentNode.next;
        }
        return head;
    }
}

