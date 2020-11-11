package com.home.task70;

//70. Climbing Stairs
public class Task70Solution {
    public int climbStairs(int n) {
        int[] tmp = new int[Math.max(2, n)];
        tmp[0] = 1;
        tmp[1] = 2;
        for (int i = 2; i < tmp.length; i++) {
            tmp[i] = tmp[i - 1] + tmp[i - 2];
        }
        return tmp[n - 1];
    }
}
