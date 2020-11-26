package com.home.task76;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task76Solution {
    public static void main(String[] args) {
        List<Integer> list =  new ArrayList<>(400000);

        long start = System.currentTimeMillis();
        for (int i = 0; i <400000 ; i++) {
            list.add(i);
        }

        System.err.println(System.currentTimeMillis()-start);

         list =  new ArrayList<>();
         start = System.currentTimeMillis();

        for (int i = 0; i <400000 ; i++) {
            list.add(i);
        }
        System.err.println(System.currentTimeMillis()-start);
    }
    public String minWindow(String s, String t) {
        int [] deff = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        if(t.length()>s.length() || !containsAll(s,t)) {
            return "";
        }

      //  s = trim(s,t);
        long start = System.currentTimeMillis();
        int[] startEndIndex=  findWindow(s, 0, s.length()-1, t, deff);
        if(startEndIndex==deff){
            return "";
        }
         startEndIndex= trimRange(s, startEndIndex[0], startEndIndex[1], t, deff, true, false);
        int startIndex = startEndIndex[0];
        int endIndex = startEndIndex[1];

        int[] minRange = startEndIndex;

        if(startIndex == Integer.MAX_VALUE && endIndex==Integer.MIN_VALUE) {
            return "";
        }
        System.err.println(System.currentTimeMillis() - start);
         start = System.currentTimeMillis();

        if((minRange[1]-minRange[0])==(t.length()-1)) {
            return s.substring(minRange[0],minRange[1]+1);
        }
        int count = 0;

        char rightLetter= s.charAt(startIndex);
        //move window

        startIndex = startIndex + 1;
        endIndex = Math.min(endIndex + 1, s.length()-1);

        while(startIndex<=s.length()-t.length() && endIndex<s.length()) {
            while( endIndex<s.length() && s.charAt(endIndex)!= rightLetter) {
                endIndex = endIndex + 1;
            }
            if(endIndex>=s.length()){
                break;
            }
            int[] nextStartEndIndex = trimRange(s,startIndex,  endIndex, t, deff, true, false);

            if(startIndex==nextStartEndIndex[0] && endIndex==nextStartEndIndex[1]){
                rightLetter = s.charAt(startIndex);
                endIndex++;
                continue;
            }
            if(nextStartEndIndex[0] == Integer.MAX_VALUE && nextStartEndIndex[1]==Integer.MIN_VALUE) {
               continue;
            }
            if((nextStartEndIndex[1]-nextStartEndIndex[0])==(t.length()-1)) {
                return s.substring(nextStartEndIndex[0],nextStartEndIndex[1]+1);
            }
            if((nextStartEndIndex[1]-nextStartEndIndex[0])<(minRange[1]-minRange[0])){
                minRange = nextStartEndIndex;
            }
            startIndex = nextStartEndIndex[0];
          //  endIndex = nextStartEndIndex[1];
            rightLetter = s.charAt(startIndex);
            endIndex++;

        }
        System.err.println(System.currentTimeMillis() - start);
        System.err.println("Iterations: " + count);
        return s.substring(minRange[0],minRange[1]+1);
    }

    public int [] findWindow(String s, int startIndex, int endIndex, String  t, int deff []) {



        StringBuilder tTmp = new StringBuilder(t);
        int count = tTmp.length();
        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;

        for (int i = startIndex; i <=endIndex ; i++) {
            String letter = ""+s.charAt(i);

            int tTmpIndex = tTmp.indexOf(letter);


                 // found letter in the word
            if(tTmpIndex!=-1){
                count--;
                tTmp.setCharAt(tTmpIndex,'_');
                leftIndex = Math.min(leftIndex, i);
                rightIndex = Math.max(rightIndex, i);
            }
            // finded all letters
            if(count==0) {
                break;
            }
        }

        return count == 0? new int[] {leftIndex, rightIndex} : deff;
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

    int [] trimRange(String s, int startIndex, int endIndex, String  t, int deff [], boolean trimRangeLeft, boolean trimRangeRight) {
        int leftIndex  = startIndex;
        int rightIndex  = endIndex;
        if(trimRangeLeft) {
            while (findWindow(s, leftIndex + 1, rightIndex, t, deff) != deff) {
                leftIndex++;
            }
        }

        if(trimRangeRight) {
            while (findWindow(s, leftIndex, rightIndex - 1, t, deff) != deff) {
                rightIndex--;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }

}

