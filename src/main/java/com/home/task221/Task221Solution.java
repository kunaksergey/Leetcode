package com.home.task221;

//221. Maximal Square
public class Task221Solution {

    public int maximalSquare(char[][] matrix) {
        int maximalSquare = 0;

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {

                if (matrix[x][y] == '1') {
                    int startX = x;
                    int startY = y;
                    int endX = startX;
                    int endY = startY;
                    while ((endX + 1) < matrix.length && (endY + 1) < matrix[endX + 1].length && matrix[endX + 1][endY + 1] == '1') {
                        int tmpX = endX + 1;
                        int tmpY = endY + 1;
                        boolean valid = true;
                        for (int i = tmpX; i >= startX; i--) {
                            if (matrix[i][tmpY] != '1') {
                                valid = false;
                                break;
                            }
                        }
                        if (!valid) {
                            break;
                        }
                        for (int i = tmpY; i >= startY; i--) {
                            if (matrix[tmpX][i] != '1') {
                                valid = false;
                                break;
                            }
                        }
                        if (!valid) {
                            break;
                        }
                        endX = tmpX;
                        endY = tmpY;
                    }
                    int square = getSquare(startX, startY, endX, endY);
                    maximalSquare = Math.max(maximalSquare, square);
                }

            }
        }
        return maximalSquare;
    }

    private int getSquare(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1 + 1) * Math.abs(y2 - y1 + 1);
    }
}
