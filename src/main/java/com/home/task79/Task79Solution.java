package com.home.task79;


import com.home.core.ArrayHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 79. Word Search
public class Task79Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) return false;
        char firstLetter = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (firstLetter == board[i][j]) {

                    // consists from one letter
                    if (word.length() == 1) {
                        return true;
                    }
                    HashSet<ArrayHolder<Integer>> store = new HashSet<>();
                    store.add(convert(new int[]{i, j})); // add start position to store
                    int[] firstPosition = new int[]{i, j};
                    List<int[]> neighboaringPositions = getNeighboaringPositions(board, firstPosition, store);

                    for (int k = 0; k < neighboaringPositions.size(); k++) {
                        if (exist(board, word.substring(1), neighboaringPositions.get(k), store)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int[] currentPosition, HashSet<ArrayHolder<Integer>> store) {
        ArrayHolder<Integer> convertedCurrentPosition = convert(currentPosition);
        if (word.length() == 0) {
            return false;
        }
        char letter = word.charAt(0);
        char boardLetter = board[currentPosition[0]][currentPosition[1]];
        if (letter != boardLetter) {
            return false;
        } else {
            store.add(convertedCurrentPosition);
            if (word.length() == 1) {
                return true;
            }
        }

        List<int[]> neighboringPossitions = getNeighboaringPositions(board, currentPosition, store);
        for (int i = 0; i < neighboringPossitions.size(); i++) {
            int[] neighboringPossition = neighboringPossitions.get(i);
            if (exist(board, word.substring(1), neighboringPossition, store)) {
                return true;
            }
        }
        // if not found path need remove used position
        store.remove(convertedCurrentPosition);
        return false;
    }

    private List<int[]> getNeighboaringPositions(char[][] board, int[] startPosition, HashSet<ArrayHolder<Integer>> store) {
        List<int[]> positions = new ArrayList<>();
        int[][] candidats = {
                {startPosition[0], startPosition[1] - 1}, //left
                {startPosition[0], startPosition[1] + 1}, //right
                {startPosition[0] - 1, startPosition[1]}, // top
                {startPosition[0] + 1, startPosition[1]} //bottom
        };

        for (int i = 0; i < candidats.length; i++) {
            if (valid(candidats[i], board.length - 1, board[0].length - 1) && !contains(candidats[i], store)) {
                positions.add(candidats[i]);
            }
        }
        return positions;
    }

    private boolean valid(int[] candidat, int x, int y) {
        return (candidat[0] >= 0 && candidat[0] <= x) && (candidat[1] >= 0 && candidat[1] <= y);
    }

    private boolean contains(int[] arr, HashSet<ArrayHolder<Integer>> store) {
        return store.contains(convert(arr));
    }

    private ArrayHolder<Integer> convert(int[] arr) {
        return new ArrayHolder<>(Arrays.stream(arr).boxed().toArray(Integer[]::new));
    }
}

