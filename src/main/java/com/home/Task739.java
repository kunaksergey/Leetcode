package com.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task739 {
    public static void main(String[] args) {
        Task739 task= new Task739();
        int [] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.err.println(Arrays.toString(task.dailyTemperatures(t)));
    }

    public int[] dailyTemperatures(int[] T) {
        int [] result= new int[T.length];
        for (int i = 0; i <T.length ; i++) {
            for (int j = i+1; j <T.length ; j++) {
                if(T[j]>T[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}
