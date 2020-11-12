package com.home.task85;

// 85. Maximal Rectangle
public class Task85Solution {
    public int maximalRectangle(char[][] matrix) {
        int maximalRectangle =0;

        for(int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
            if(matrix[i][j]==1){
                int countRectangle = countRectangle(i,j);
                maximalRectangle = Math.max(maximalRectangle,countRectangle);
            }
            }

        }
        return maximalRectangle;
    }

    private int countRectangle(int i, int j) {
        return 1;
    }
}
