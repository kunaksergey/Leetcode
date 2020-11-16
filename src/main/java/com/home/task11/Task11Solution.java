package com.home.task11;

//11. Container With Most Water
public class Task11Solution {
    public int maxArea(int[] height) {
    int maxArea = 0;
        for (int i = 0; i <height.length-1 ; i++) {
            int leftValue = height[i];
            for (int j = 0;j <height.length ; j++) {
                if(i==j) continue;
                int rightValue = height[j];
                int currentArea = Math.abs(i-j)*Math.min(leftValue,rightValue);
                maxArea = Math.max(maxArea,currentArea);
            }
        }
        return maxArea;
    }
}
