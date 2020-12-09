package com.home.task94;

import com.home.core.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 94. Binary Tree Inorder Traversal
public class Task94Solution {

            public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root==null){
                return result;
            }
            // if node is leaf
            if(root.left==null && root.right==null){
                return new ArrayList<>(Arrays.asList(root.val));
            }

            int current = root.val;

             if(root.left!= null) {
                List<Integer> left = inorderTraversal(root.left);
                left.add(current);
                result.addAll(left);
            }
             if(root.right!= null) {
                 if(root.left!= null) {
                     result.addAll(inorderTraversal(root.right));
                 }else{
                     result.add(current);
                     result.addAll(inorderTraversal(root.right));
                 }
             }
             return result;
        }
}
