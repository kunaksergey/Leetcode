package com.home.task55;

// 55. Jump Game
public class Task55Solution {
    public boolean canJump(int[] nums) {
        if (nums.length==1) return true;

        boolean canJump = true;
        //boolean canJumpOnRange = true;
        int indexZero = -1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]==0){
                if(indexZero==-1) {
                    indexZero = i;
                    canJump = false;
                    continue;
                }
            } else{
                if(indexZero!=-1) { // zero was find
                    if(i+nums[i]>indexZero || i+nums[i]==nums.length-1){
                        canJump = true;
                        indexZero = -1;
                    }
                }
            }
        }
        return canJump;
    }
}
