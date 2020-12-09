package com.home.task76;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task76Solution {

    final int defaultLeftIndex = Integer.MAX_VALUE;
    final int defaultRightIndex = Integer.MIN_VALUE;
    final int maxlength = 100000;
    final String emptyValue = "";
    int[] minRange = new int[]{defaultLeftIndex, defaultRightIndex};

    public String minWindow(String s, String t) {
        if (t.length() > s.length() || !containsAll(s, t) || t.length() > maxlength || s.length() > maxlength) {
            return emptyValue;
        }

        WordMapStore wordMapStore = new WordMapStore(t);

        //find the window with our word
        int[] windowsRange = findWindow(s, 0, s.length() - 1, wordMapStore);

        //no solution
        if (windowsRange[0] == defaultLeftIndex || windowsRange[1] == defaultRightIndex) {
            return emptyValue;
        }

        // optimal solution
        if ((windowsRange[1] - windowsRange[0]) == (t.length() - 1)) {
            return s.substring(windowsRange[0], windowsRange[1] + 1);
        }

        // save window range as min
        minRange = windowsRange;

        // startEndIndex= trimRange(s, startEndIndex[0], startEndIndex[1], t, deff, true, false);
        int leftIndex = windowsRange[0];
        int rightIndex = windowsRange[1];

        //move window
        boolean moveToNext = true;

        while (moveToNext && (canMoveLeft(leftIndex + 1, s, t) || canMoveRight(rightIndex + 1, s))) {
            char letterToFind = s.charAt(leftIndex);

            // move right side
            boolean movedRight = false;
            while (canMoveRight(rightIndex + 1, s)) {
                rightIndex++;
                char currentChar = s.charAt(rightIndex);

                //save all chars that has word till right letter
                if (currentChar != letterToFind) {
                    if (wordMapStore.has(currentChar)) {
                        wordMapStore.add(currentChar);
                    }
                } else {
                    if (wordMapStore.has(currentChar)) {
                        wordMapStore.add(currentChar);
                        movedRight = true;
                        break;
                    }
                }
            }

            //move left side
            boolean movedLeft = false;
            if (wordMapStore.remove(s.charAt(leftIndex))) {
                movedLeft = true;
            }

            while (movedLeft && canMoveLeft(leftIndex + 1, s, t)) {
                leftIndex++;
                char leftChar = s.charAt(leftIndex);
                if (wordMapStore.has(leftChar)) {
                    boolean removed = wordMapStore.remove(leftChar);
                    if (!removed) { // i.e
                        break;
                    } else {
                        movedLeft = true;
                    }
                } else {
                    // nothing;
                }
            }

            moveToNext = movedLeft || movedRight;

            if (moveToNext) {
                updateMinRange(new int[]{leftIndex, rightIndex});
            }
        }
        return s.substring(minRange[0], minRange[1] + 1);
    }

    private boolean canMoveLeft(int leftIndex, String s, String t) {
        return leftIndex <= s.length() - t.length();
    }

    private boolean canMoveRight(int rightIndex, String s) {
        return rightIndex < s.length();
    }

    private void updateMinRange(int[] range) {
        if ((range[1] - range[0]) < (minRange[1] - minRange[0])) {
            minRange[0] = range[0];
            minRange[1] = range[1];
        }
    }

    private int[] findWindow(String s, int startIndex, int endIndex, WordMapStore wordMapStore) {
        int leftIndex = defaultLeftIndex;
        int rightIndex = defaultRightIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            char c = s.charAt(i);
            if (leftIndex == defaultLeftIndex && wordMapStore.has(c)) {
                leftIndex = i; // found left board
            }
            wordMapStore.add(c);
            if (wordMapStore.isFull()) {
                rightIndex = i;
                break;
            }
        }
        return trimLeft(s, leftIndex, rightIndex, wordMapStore);
    }

    private int[] trimLeft(String s, int leftIndex, int rightIndex, WordMapStore wordMapStore) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (wordMapStore.has(s.charAt(i)) && !wordMapStore.remove(s.charAt(i))) {
                leftIndex = i;
                break;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    private boolean containsAll(String s, String t) {
        List<Character> wordSet = IntStream.range(0, t.length()).mapToObj(i -> t.charAt(i)).collect(Collectors.toList());
        List<Character> strSet = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(i)).collect(Collectors.toList());
        return strSet.containsAll(wordSet);

    }

    //store for letters
    private static class WordMapStore {
        Map<Character, int[]> wordMap;

        WordMapStore(String word) {
            this.wordMap = convertTo(word);
        }

        private Map<Character, int[]> convertTo(String t) {
            Map<Character, int[]> characterMap = new TreeMap<>();
            for (int i = 0; i < t.length(); i++) {
                if (!characterMap.containsKey(t.charAt(i))) {
                    characterMap.put(t.charAt(i), new int[2]); //int[0] - need letters; int[1]-found letters
                }
                characterMap.get(t.charAt(i))[0]++; //increment founded character;
            }
            return characterMap;
        }

        void add(char c) {
            if (this.wordMap.containsKey(c)) {
                this.wordMap.get(c)[1]++;
            }
        }

        boolean remove(char c) {
            if (canRemove(c)) {
                if (this.wordMap.get(c)[1] > 0) {
                    this.wordMap.get(c)[1]--;
                }
                return true;
            } else {
                return false;
            }
        }

        boolean isFull() {
            long count = wordMap.values().stream().filter(arr -> arr[1] >= arr[0]).count();
            return count == wordMap.values().size();
        }

        private boolean canRemove(char c) {
            if (!this.wordMap.containsKey(c)) {
                return false;
            }
            int[] ints = this.wordMap.get(c);
            return ints[1] > ints[0];
        }

        boolean has(char c) {
            return this.wordMap.containsKey(c);
        }
    }
}

