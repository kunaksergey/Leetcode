package com.home.task85;

// 85. Maximal Rectangle
public class Task85Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int maximalRectangle = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int[] borderRectangle = borderRectangle(i, j, matrix);
                    int countRectangle = countRectangle(borderRectangle, matrix);
                    maximalRectangle = Math.max(maximalRectangle, countRectangle);
                }
            }

        }
        return maximalRectangle;
    }

    private int[] borderRectangle(int startX, int startY, char[][] matrix) {
        int endX = startX;
        int endY = startY;

        // find by X axis
        boolean finding = true;
        while (finding) {
            int nextValue = endX + 1;
            if ((nextValue) < matrix.length && matrix[nextValue][startY] == '1') {
                endX = nextValue;
            } else {
                finding = false;
            }
        }

        // find by Y axis
        finding = true;
        while (finding) {
            int nextValue = endY + 1;
            if (nextValue < matrix[startX].length && matrix[startX][nextValue] == '1') {
                endY = nextValue;
            } else {
                finding = false;
            }
        }
        return new int[]{startX, endX, startY, endY};
    }


    private int countRectangle(int[] border, char[][] matrix) {
        int startX = border[0];
        int endX = border[1];
        int startY = border[2];
        int endY = border[3];
        int minY = endY;
        int countRectangle = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (matrix[i][j] == '0') {
                    endY = j-1;
                    break;
                }
            }
            countRectangle = Math.max(countRectangle ,  countRectangle(new int[]{startX, startY}, new int[]{i, endY}));
        }
        return countRectangle;
    }

    private int countRectangle(int[] leftBorder, int[] rightBorder) {
        return ((rightBorder[0] - leftBorder[0]) + 1) * ((rightBorder[1] - leftBorder[1]) + 1);
    }
}
