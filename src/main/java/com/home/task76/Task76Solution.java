package com.home.task76;

import java.util.Arrays;

public class Task76Solution {
    public String minWindow(String s, String t) {
        if(s.contains(t)) return t;
        return findWindow(s, 0, s.length(), t ,true);
    }

    public String findWindow(String s, int startIndex, int endIndex, String t, boolean deepFind) {
        if(t.length()>s.length()){
            return "";
        }
        int [] arr = new int[t.length()];
        StringBuilder tTmp = new StringBuilder(t);
        int count = t.length();
        Arrays.fill(arr,-1);

        int leftIndex = Integer.MAX_VALUE;
        int rightIndex = Integer.MIN_VALUE;;

        for (int i = startIndex; i <endIndex ; i++) {
            String letter = ""+s.charAt(i);
            int tTmpIndex = tTmp.indexOf(letter);

            // found letter in the word
            if(tTmpIndex!=-1){
                arr[tTmpIndex] = i;
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

        String result = "";
        //move window
        if (count==0 && deepFind) { // found
            result = s.substring(leftIndex, rightIndex + 1);
            int nextStartIndex = leftIndex + 1;
            int nextEndIndex = rightIndex + 1;
            nextEndIndex = Math.min(nextEndIndex, s.length());
            String nextResult = "";
            while(nextStartIndex<=s.length()-t.length()) {
//                String next = s.substring(nextStartIndex, nextEndIndex+1);
                nextResult = findWindow(s,nextStartIndex,  nextEndIndex, t, false);
                if(nextResult!=""){
                    result = result.length() < nextResult.length() ? result : nextResult;
                }
                nextStartIndex++;
                nextEndIndex = Math.min(nextEndIndex+1, s.length());
            }
        }else if(count==0){
            result = s.substring(leftIndex, rightIndex+1);
        }
        return result;
    }

}

