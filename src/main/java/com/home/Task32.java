package com.home;

public class Task32 {
    public static void main(String[] args) {
        Task32 task4 = new Task32();
        System.out.println(task4.longestValidParentheses("(()"));
        System.out.println(task4.longestValidParentheses(")()())"));
        System.out.println(task4.longestValidParentheses(""));

    }

    public int longestValidParentheses(String s) {
        int result = 0;
        int count = 0;
        boolean previousValid = false;
        for (int i = 0; i <s.length()-1 ; i++) {
            if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
                   count=count+2;
            }
        }
        return Math.max(result,count);
    }
}
