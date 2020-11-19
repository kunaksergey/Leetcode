package com.home.task62;

import java.util.Arrays;
import java.util.HashMap;

//62. Unique Paths
public class Task62Solution {
    public int uniquePaths(int m, int n) {
        int[] endPosition = {m, n};
        return uniquePaths(1, 1, endPosition, new HashMap<>());
    }

    private int uniquePaths(int m, int n, int[] endPosition, HashMap<ArrayHolder<Integer>, Integer> store) {
        if (m == endPosition[0] && n == endPosition[1]) {
            return 1;
        }

        int count = 0;

        if (n + 1 <= endPosition[1]) {
            int[] path = {m, n+1};
            count = getValue(path,endPosition,store);
        }

        if (m + 1 <= endPosition[0]) {
            int[] path = {m+1, n};
            count = count + getValue(path,endPosition,store);
        }
        return count;
    }

    private int getValue(int path[], int[] endPosition, HashMap<ArrayHolder<Integer>, Integer> store){
        int value = 0;
        ArrayHolder<Integer> arrayHolder= new ArrayHolder<>(Arrays.stream(path).boxed().toArray(Integer[]::new ));
        if(store.containsKey(arrayHolder)){
            value = store.get(arrayHolder);
        }else{
            value = uniquePaths(path[0], path[1], endPosition, store);
            store.put(arrayHolder,value);
        }
        return value;
    }

    public static final class ArrayHolder<T> {

        private final T[] t;

        public ArrayHolder(T[] t) {
            this.t = t;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Arrays.hashCode(this.t);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ArrayHolder<T> other = (ArrayHolder<T>) obj;
            if (!Arrays.equals(this.t, other.t)) {
                return false;
            }
            return true;
        }
    }

}
