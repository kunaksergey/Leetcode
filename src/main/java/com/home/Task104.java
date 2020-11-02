package com.home;

public class Task104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(Solution.maxDepth(root));

    }
}

/**
 * Definition for a binary tree node.*/
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    static int maxDepth(TreeNode root) {
        if(root == null ){
            return 0;
        }
        int leftMax = root.left!=null ?maxDepth(root.left):0;
        int rightMax = root.right!=null ?maxDepth(root.right):0;
        return 1+Math.max(leftMax, rightMax);
    }

}
