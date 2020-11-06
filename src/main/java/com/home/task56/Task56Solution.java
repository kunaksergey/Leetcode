package com.home.task56;

import java.util.Arrays;

//56. Merge Intervals
public class Task56Solution {
    public int[][] merge(int[][] intervals) {
        boolean findning = true;
        while (findning) {
            findning = false;
            for (int i = 0; i < intervals.length - 1; i++) {
                for (int j = 1; j < intervals.length; j++) {
                    if (i==j) continue;
                    if (isIntersectedIntervals(intervals[i], intervals[j])) {
                        intervals[i] = mergeIntervals(intervals[i], intervals[j]);
                        intervals = removeByIdex(intervals, j);
                        findning = true;
                        break;
                    }
                }
                if(findning) break;
            }

        }
      return intervals;
    }

    private int[][] removeByIdex(int[][] intervals, int j) {
        int [][] result = new int[intervals.length-1][];
        System.arraycopy(intervals, 0, result, 0, j);
        System.arraycopy(intervals, j + 1, result, j, intervals.length - j - 1);
        return result;
    }

    private int[] mergeIntervals(int[] leftInterval, int[] rightIinterval) {
        return new int[] {
            Math.min(leftInterval[0], rightIinterval[0]),
            Math.max(leftInterval[1], rightIinterval[1])
        };
    }

    private boolean isIntersectedIntervals(int[] leftInterval, int[] rightInterval) {
        if (leftInterval[1] < rightInterval[0] || rightInterval[1] < leftInterval[0]) {
            return false;
        }
        return true;
    }
}
