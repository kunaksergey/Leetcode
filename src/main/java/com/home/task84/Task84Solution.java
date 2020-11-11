package com.home.task84;

//84. Largest Rectangle in Histogram
public class Task84Solution {
    public int largestRectangleArea(int[] heights) {
        int top = maxOfArr(heights);
        int max = 0;
        for (int i = 0; i <= top; i++) {
            int[] currentHeights = cutHeights(heights, i);
            int currentTop = top-1;
            for (int j = 0; j < currentHeights.length; j++) {

                if (currentHeights[j] == currentTop) {
                    max = Math.max(max, currentTop);
                    if (j + 1 < heights.length) {
                        j++;
                        while (currentHeights[j] == currentTop) {
                            max = max + currentTop;
                            if (j + 1 < currentHeights.length) {
                                j++;
                            } else {
                                break;
                            }

                        }
                    }
                }
            }
        }
        return max;
    }

    private int[] cutHeights(int[] heights, int i) {
        int[] result = new int[heights.length];
        for (int j = 0; j < heights.length; j++) {
            int value = (heights[j] - i) >= 0 ? heights[j] - i : 0;
            result[j] = value;
        }
        return result;
    }

    int maxOfArr(int[] heights) {
        int result = heights[0];
        for (int i = 1; i < heights.length; i++) {
            result = Math.max(result, heights[i]);
        }
        return result;
    }
}
