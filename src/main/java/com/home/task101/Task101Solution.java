package com.home.task101;

import com.home.core.TreeNode;

import java.util.Arrays;

public class Task101Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        int[] combinedLeft = combine(left, false);
        int[] combinedRight = combine(right, true);
        return Arrays.equals(combinedLeft,combinedRight);
    }

    private int[] combine(TreeNode node, boolean simetric) {
        int[] result = {node.val};

        TreeNode leftNode, rightNode;

        if (simetric) {
            leftNode = node.right;
            rightNode = node.left;
        } else {
            leftNode = node.left;
            rightNode = node.right;
        }

        int[] left;
        if (leftNode != null) {
            left = combine(leftNode, simetric);
        }else{
            left = new int [] {Integer.MIN_VALUE};
        }

        result = merge(result, left);

        int[] right;
        if (rightNode != null) {
            right = combine(rightNode, simetric);
        }else{
            right = new int [] {Integer.MIN_VALUE};
        }
        result = merge(result, right);
        return result;
    }

    int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }
}
