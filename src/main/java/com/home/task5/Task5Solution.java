package com.home.task5;

public class Task5Solution {
    public String longestPalindrome(String s) {
        String result ="";
        for (int i = 0; i <s.length() ; i++) {
            String polindrome = getPolindromeByIndex(i,s);
            result = result.length() >= polindrome.length() ? result : polindrome;
        }
        return  result;
    }

    private String getPolindromeByIndex(int i, String s) {
        String polindromeByIndex = getPolindromeByRange(i, i, s);
        String polindromeByIndexWithOffset = getPolindromeByRange(i, i + 1, s);
        return polindromeByIndex.length() >= polindromeByIndexWithOffset.length() ? polindromeByIndex : polindromeByIndexWithOffset;
    }

    private String getPolindromeByRange(int leftIndex, int rightIndex, String s) {
        String polindrome = "";
        while(leftIndex>=0 && rightIndex<s.length()){
            if(s.charAt(leftIndex)==s.charAt(rightIndex)){
                polindrome = s.substring(leftIndex,rightIndex+1);
                leftIndex--;
                rightIndex++;
            }else{
                break;
            }
        }
        return polindrome;
    }
}
