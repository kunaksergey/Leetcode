package com.home.task124;

import com.home.core.TreeNode;

//124. Binary Tree Maximum Path Sum
public class Task124Solution {
    public int maxPathSum(TreeNode root) {
        int result = root.val;
        int min = -1001;
        int leftValue = root.left != null ? maxPathSum(root.left) : min;
        int rightValue = root.right != null ? maxPathSum(root.right) : min;

        result = Math.max(result, leftValue);
        result = Math.max(result, rightValue);
        result = Math.max(result, root.val + leftValue);
        result = Math.max(result, root.val + rightValue);
        result = Math.max(result, root.val + leftValue + rightValue);

        return result;
    }

}
