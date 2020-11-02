package com.home.task3;
// 3. Longest Substring Without Repeating Characters
   class Task3Solution {
        public int lengthOfLongestSubstring(String s) {
           if (s.length()<=1){
               return s.length();
           }
           int maxLength = 1;

            for (int i = 0; i <s.length()-1 ; i++) {
                String currentStr = s.substring(i,i+1);
                for (int j = i+1; j <s.length(); j++) {
                    char currentChar = s.charAt(j);
                    if(currentStr.indexOf(currentChar)== -1) {
                        currentStr += s.substring(j,j+1);
                    }
                    else{
                        break;
                    }
                    maxLength = Math.max(maxLength,currentStr.length());
                 }
            }
           return maxLength;
        }
    }

