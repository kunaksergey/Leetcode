package com.home.task139;

import java.util.List;

public class Task139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean wordBreak = false;
        if (s.length() != 0 && wordDict.size() == 0) {
            return wordBreak;
        }
        if (s.length() == 0) return true;

        for (String str : wordDict) {
            int index = s.indexOf(str);
            if (s.indexOf(str) != -1) {
                String newStr = s.substring(0, index) + s.substring(index + str.length());
                if (wordBreak(newStr, wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }
}
