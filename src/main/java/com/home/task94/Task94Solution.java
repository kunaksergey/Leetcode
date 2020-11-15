package com.home.task94;

import com.home.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 94. Binary Tree Inorder Traversal
public class Task94Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root==null){
                return result;
            }

            result.add(root.val);

            if(root.left!=null){
                result.addAll(inorderTraversal(root.left));
                if(result.get(0)<result.get(1)){
                    Integer tmp = result.get(0);
                    result.set(0,result.get(1));
                    result.set(1,tmp);
                }
            }


            if(root.right!=null){
            result.addAll(inorderTraversal(root.right));
            }

            return result;
        }
}
