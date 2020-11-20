package com.home.task64;

import com.home.core.ArrayHolder;

import java.util.Arrays;
import java.util.HashMap;

// 64. Minimum Path Sum
public class Task64Solution {
    public int minPathSum(int[][] grid) {
        return minPathSum(new int[]{0,0}, grid, new HashMap<>());
    }

    private int minPathSum(int[] startPosition, int[][] grid, HashMap<ArrayHolder<Integer>, Integer> store) {
        int m = startPosition[0];
        int n = startPosition[1];
        int endPositionM = grid[0].length-1;
        int endPositionN = grid.length-1;


        if (  m== endPositionM && n == endPositionN ) {
            return grid[n][m];
        }


        int min = Integer.MAX_VALUE;
        if (n + 1 <= endPositionN) {
            int[] path = {m, n+1};
            min = getValue(path,grid,store);
        }

        if (m + 1 <= endPositionM) {
            int[] path = {m+1, n};
            min = Math.min(min, getValue(path, grid, store));
        }
        return grid[n][m] + min;
    }

    private int getValue(int startPosition[], int[][] grid, HashMap<ArrayHolder<Integer>, Integer> store){
        int value = 0;
        ArrayHolder<Integer> arrayHolder= new ArrayHolder<>(Arrays.stream(startPosition).boxed().toArray(Integer[]::new ));
        if(store.containsKey(arrayHolder)){
            value = store.get(arrayHolder);
        }else{
            value = minPathSum(startPosition, grid, store);
            store.put(arrayHolder,value);
        }
        return value;
    }

}
