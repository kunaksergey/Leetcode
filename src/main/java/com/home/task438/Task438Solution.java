package com.home.task438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 438. Find All Anagrams in a String
public class Task438Solution {
    int maxLength = 20100;

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s.length()<=maxLength && p.length()<=maxLength && s.length()>=p.length()){
            char[] charsW = p.toCharArray();
            Arrays.sort(charsW);
            for (int i = 0; i <=s.length()-p.length() ; i++) {
                String str = s.substring(i,i+p.length());
                if(isAnagram(str, charsW)){
                    result.add(i);
                }
            }
        }
        return result;
    }

    private boolean isAnagram(String s, char[] charsW) {
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        return Arrays.equals(charsS, charsW);
    }
}
