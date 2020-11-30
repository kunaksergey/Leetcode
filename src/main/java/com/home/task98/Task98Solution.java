package com.home.task98;

import com.home.core.TreeNode;

import java.util.*;
// 98. Validate Binary Search Tree
public class Task98Solution {
    private boolean isValidBST = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        getSubtreeArr(root);
        return isValidBST;
    }

    private List<Integer> getSubtreeArr(TreeNode root) {
        int currentVal = root.val;
        List<Integer> result = new ArrayList<>(Arrays.asList(currentVal));

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.left != null) {
            List<Integer> leftSubTree = getSubtreeArr(root.left);
            if (currentVal <= leftSubTree.get(leftSubTree.size()-1)) {
                this.isValidBST = this.isValidBST && false;

            }
            result.addAll(leftSubTree);
        }

        if (root.right != null) {
            List<Integer> rightSubTree = getSubtreeArr(root.right);
            if (currentVal >= rightSubTree.get(0)) {
                this.isValidBST = this.isValidBST && false;
            }
            result.addAll(rightSubTree);
        }
        Collections.sort(result);
        return result;
    }
}
