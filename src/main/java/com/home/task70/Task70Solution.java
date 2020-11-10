package com.home.task70;

//70. Climbing Stairs
public class Task70Solution {
    public int climbStairs(int n) {
          int result = 0;
        if (n >= 1) {
            result = result + 1 + climbStairs(n - 1);

        }
        if (n >= 2) {
            result = result + 1 + climbStairs(n - 2);
        }
        return result;
    }
}
