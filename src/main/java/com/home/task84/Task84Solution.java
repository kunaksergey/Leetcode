package com.home.task84;

//84. Largest Rectangle in Histogram
public class Task84Solution {
    public int largestRectangleArea(int[] heights) {
        int top = maxOfArr(heights);
        int [] diff = deviation(heights,top);
        int max = 0;
        for (int i = 0; i < diff.length; i++) {
            int[] currentHeights = cutHeights(heights, diff[i], top);
            int currentTop = heights[i];
            for (int j = 0; j < currentHeights.length; j++) {
                int currentMax = Integer.MIN_VALUE;
                if (currentHeights[j] == currentTop) {
                    currentMax = Math.max(currentMax, currentTop);
                    if (j + 1 < heights.length) {
                        j++;
                        while (currentHeights[j] == currentTop) {
                            currentMax = currentMax + currentTop;
                            if (j + 1 < currentHeights.length) {
                                j++;
                            } else {
                                break;
                            }
                        }
                    }
                    max = Math.max(max,currentMax);
                }
            }
        }
        return max;
    }

    private int[] cutHeights(int[] heights, int i, int top) {
        int[] result = new int[heights.length];
        for (int j = 0; j < heights.length; j++) {
            result[j] = Math.min(heights[j], top-i);
        }
        return result;
    }

    private int maxOfArr(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i]);
        }
        return result;
    }

    private int[] deviation(int[] heights, int top) {
        int[] diff = new int[heights.length];
        for (int i = 0; i <heights.length ; i++) {
            diff[i] = top - heights[i];
        }
        return diff;
    }
}
