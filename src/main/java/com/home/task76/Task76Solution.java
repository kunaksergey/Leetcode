package com.home.task76;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task76Solution {

    final int[] deff = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
    final int maxlength = 100000;
    final String emptyValue = "";
    int[] minRange = deff;

    public String minWindow(String s, String t) {
        if (t.length() > s.length() || !containsAll(s, t) || t.length() > maxlength || s.length() > maxlength) {
            return emptyValue;
        }

        WordMapStore wordMapStore = new WordMapStore(t);

        int[] windowsRange = findWindow(s, 0, s.length() - 1, wordMapStore);

        //no solution
        if (windowsRange[0] == deff[0] || windowsRange[1]==deff[1]) {
            return emptyValue;
        }

        // optimal solution
        if ((windowsRange[1] - windowsRange[0]) == (t.length() - 1)) {
            return s.substring(windowsRange[0], windowsRange[1] + 1);
        }


        // save first found range as min
        minRange = windowsRange;

        // startEndIndex= trimRange(s, startEndIndex[0], startEndIndex[1], t, deff, true, false);
        int startIndex = windowsRange[0];
        int endIndex = windowsRange[1];



        //move window
        boolean moveToNext = true;

        while (moveToNext && (canMoveLeft(startIndex+1, s, t) || canMoveRight(endIndex+1, s))) {
            char letterToFind = s.charAt(startIndex);
         
            // move right side
            boolean movedRight = false;
            while (canMoveRight(endIndex+1, s)) {
                endIndex++;
                char currentChar = s.charAt(endIndex);

                //save all chars that has word till right letter
                if(currentChar != letterToFind) {
                    if (wordMapStore.has(currentChar)) {
                        wordMapStore.add(currentChar);
                    }
                }else{
                    if (wordMapStore.has(currentChar)) {
                        wordMapStore.add(currentChar);
                        movedRight = true;
                     break;
                    }
                }
 }

            //move left side

            boolean removedLeft = false;
             if(wordMapStore.remove(s.charAt(startIndex))){
                 removedLeft = true;
             };

            while (removedLeft && canMoveLeft(startIndex+1, s, t)) {
                startIndex++;
                char leftChar = s.charAt(startIndex);
                if (wordMapStore.has(leftChar)) {
                    boolean removed = wordMapStore.remove(leftChar);
                    if (!removed) { // i.e
                       break;
                    }else{
                        removedLeft = true;
                    }
                } else {
                    // nothing;
                }
            }



            if(removedLeft || movedRight) {
                updateMinRange(new int[]{startIndex, Math.min(endIndex, s.length() - 1)});
            }

            moveToNext = removedLeft || movedRight;
           }
        return s.substring(minRange[0], minRange[1] + 1);
    }

    private boolean canMoveLeft(int leftIndex, String s, String t) {
        return leftIndex <= s.length() - t.length();
    }

    private boolean canMoveRight(int rightIndex, String s) {
        return rightIndex < s.length();
    }

    public void updateMinRange(int[] range) {
        if ((range[1] - range[0]) < (minRange[1] - minRange[0])) {
            minRange[0] = range[0];
            minRange[1] = range[1];
        }
    }

    public int[] findWindow(String s, int startIndex, int endIndex, WordMapStore wordMapStore) {
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            char c = s.charAt(i);
            if(leftIndex == Integer.MAX_VALUE && wordMapStore.has(c)){
                leftIndex=i; // found left board
            }
            wordMapStore.add(c);
            if (wordMapStore.isFull()) {
                rightIndex = i;
                break;
            }
        }
        for (int i = leftIndex; i <=rightIndex ; i++) {
            if(wordMapStore.has(s.charAt(i)) && !wordMapStore.remove(s.charAt(i))){
                    leftIndex = i;
                    break;
            }
        }
        return new int[] {leftIndex, rightIndex};
    }




    public int[] findWindow(String s, int startIndex, int endIndex, String t, int deff[]) {

        if (!containsAll(s.substring(startIndex, endIndex + 1), t)) {
            return deff;
        }

        StringBuilder sTmp = new StringBuilder(s);
        int count = t.length();
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;


        for (int i = 0; i < t.length(); i++) {

            // can't find
            if (t.length() - i < count) {
                break;
            }
            String letter = "" + t.charAt(i);
            int tTmpIndex = sTmp.indexOf(letter, startIndex);

            if (tTmpIndex > endIndex) {
                break;
            }

            // found letter in the word
            if (tTmpIndex != -1) {
                count--;
                sTmp.setCharAt(tTmpIndex, '_');

                leftIndex = Math.min(tTmpIndex, leftIndex);
                rightIndex = Math.max(tTmpIndex, rightIndex);
            }
            // finded all letters
            if (count == 0) {
                break;
            }
        }

        return count == 0 ? new int[]{leftIndex, rightIndex} : deff;
    }

    private boolean containsAll(String s, String t) {
        List<Character> wordSet = IntStream.range(0, t.length()).mapToObj(i -> t.charAt(i)).collect(Collectors.toList());
        List<Character> strSet = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(i)).collect(Collectors.toList());
        return strSet.containsAll(wordSet);

    }


    private String trim(String s, String t) {
        int beginIndex = 0;
        int endIndex = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (t.indexOf(c) != -1) {
                beginIndex = i;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (t.indexOf(c) != -1) {
                endIndex = i;
                break;
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }

    int[] trimRange(String s, int startIndex, int endIndex, String t, int deff[], boolean trimRangeLeft, boolean trimRangeRight) {
        int leftIndex = startIndex;
        int rightIndex = endIndex;
        if (trimRangeLeft) {
            while (findWindow(s, leftIndex + 1, rightIndex, t, deff) != deff) {
                leftIndex++;
            }
        }

        if (trimRangeRight) {
            while (findWindow(s, leftIndex, rightIndex - 1, t, deff) != deff) {
                rightIndex--;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

    private static class WordMapStore {
        Map<Character, int[]> wordMap;

        public WordMapStore(String word) {
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

        int length() {
            int length = 0;
            for (int[] value : wordMap.values()) {
                length += value[1];
            }
            return length;
        }

        private boolean canRemove(char c) {
            if (!this.wordMap.containsKey(c)) {
                return false;
            }
            int[] ints = this.wordMap.get(c);
            return ints[1] > ints[0];
        }

        public boolean has(char c) {
            return this.wordMap.containsKey(c);
        }

    }
}

