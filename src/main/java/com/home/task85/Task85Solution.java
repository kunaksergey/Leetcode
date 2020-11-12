package com.home.task85;

// 85. Maximal Rectangle
public class Task85Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;

        int maximalRectangle =0;

        for(int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
            if(matrix[i][j]==1){
                int [] borderRectangle = borderRectangle(i,j, matrix);
                int countRectangle = countRectangle(borderRectangle, matrix);
                maximalRectangle = Math.max(maximalRectangle,countRectangle);
            }
            }

        }
        return maximalRectangle;
    }

    private int[] borderRectangle(int startX, int startY, char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return new int[]{0,0,0,0};

        int endX = matrix.length;
        int endY = matrix[0].length;

        int stopX = startX;
        while((matrix[stopX][startY]==1) && stopX<matrix.length){
            stopX++;
        }

        int stopY = startY;
        while((matrix[startX] [stopY]==1) && stopY<matrix[0].length){
            stopY++;
        }

        return new int[]{startX,stopX,startY,stopY};
    }


    private int countRectangle(int[] border, char[][] matrix){
        int count = 0;
        if(border.length!=4) return 0;

        return count;
    }
}
