package com.home;

public class Task21 {
    public static void main(String[] args) {
        Task21 task = new Task21();
        ListNode l1 = task.createL1List();
        ListNode l2 = task.createL2List();
        System.err.println(task.mergeTwoLists(l1,l2));
    }

    private ListNode createL1List() {
        return new ListNode(1,new ListNode(2,new ListNode(4)));
    }

    private ListNode createL2List() {
        return new ListNode(1,new ListNode(3,new ListNode(4)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curentNodeL1= l1;
        ListNode curentNodeL2= l2;
        ListNode result = null;
        ListNode previos = null;
        while(curentNodeL1!=null || curentNodeL2!=null){
            int val = 0;
            if(curentNodeL1!=null && curentNodeL2!=null){
                int val1= curentNodeL1.val;
                int val2= curentNodeL2.val;
                val = Math.min(val1,val2);
                if(val==val1){
                    curentNodeL1 = curentNodeL1.next;
                }else{
                    curentNodeL2 = curentNodeL2.next;
                }
            } else if(curentNodeL1!=null){
                val = curentNodeL1.val;
                curentNodeL1 = curentNodeL1.next;
            }else{
                val = curentNodeL2.val;
                curentNodeL2 = curentNodeL2.next;
            }

            ListNode current = new ListNode(val);
            if(previos!=null) {
                previos.next = current;
            }else{
                result = current;
            }
            previos = current;

        }
        return result;
    }
    /**
     * Definition for singly-linked list.
     **/
     static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



}


