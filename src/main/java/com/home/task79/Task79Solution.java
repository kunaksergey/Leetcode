package com.home.task79;


import java.util.*;

// 79. Word Search
public class Task79Solution {
    public boolean exist(char[][] board, String word) {
      if(!isValid(board, word)) return false;

       char firstLetter = word.charAt(0);
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(board[i][j]==firstLetter){
                    HashSet<ArrayHolder<Integer>> store = new HashSet<>();
                    store.add(convert(new int[]{i,j})); // add start position to store
                    if(exist(board,word.substring(1),new int[]{i,j}, store)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, String word) {
        if( word.length()>board.length*board[0].length) return false;
        Map<Character, Integer> boardMap = convertTo(board);
        Map<Character, Integer> wordMap = convertTo(word);
        for(Map.Entry<Character, Integer> entry: wordMap.entrySet()){
            Character key = entry.getKey();
            if(!boardMap.containsKey(key)){
                return false;
            }
            if(entry.getValue()>boardMap.get(key)){
                return false;
            }
        }
        return  true;
    }

    private Map<Character, Integer> convertTo(char[][] board) {
        Map<Character, Integer> converted = new HashMap<>();
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                Character character = board[i][j];
                if(!converted.containsKey(character)){
                    converted.put(character,0);
                }
                Integer currentValue = converted.get(character);
                converted.put(character, currentValue++);
            }
        }
        return converted;
    }

    private Map<Character, Integer> convertTo(String word) {
        Map<Character, Integer> converted = new HashMap<>();
        for (int i = 0; i <word.length() ; i++) {
                Character character = word.charAt(i);
                if(!converted.containsKey(character)){
                    converted.put(character,0);
                }
                Integer currentValue = converted.get(character);
                converted.put(character, currentValue++);

        }
        return converted;
    }

    boolean exist(char[][] board, String word, int[]startPosition, HashSet<ArrayHolder<Integer>> store){
        if(word.length()==0){
            return true;
        }
        boolean result = false;
        char findLetter = word.charAt(0);
        List<int[]> positions = getNewPositions(board, startPosition, store);
        for (int [] position: positions) {
            if( board[position[0]][position[1]]== findLetter){
                if(word.length()==1){
                    return true;
                } else{
                   ArrayHolder<Integer> holder = new ArrayHolder<>(Arrays.stream(position).boxed().toArray(Integer[]::new));
                   store.add(holder);
                   boolean exists = exist(board, word.substring(1),position, store);
                   if(!exists) {
                       store.remove(holder);
                   }
                    result = result || exists;
                }

            }
        }
        return result;
    }

    private List<int[]> getNewPositions(char[][] board, int[] startPosition, HashSet<ArrayHolder<Integer>> store) {
        List<int[]> positions = new ArrayList<>();
          int [][] candidats = {
                {startPosition[0], startPosition[1]-1}, //left
                {startPosition[0], startPosition[1]+1}, //right
                {startPosition[0]-1, startPosition[1]}, // top
                {startPosition[0]+1, startPosition[1]} //bottom
        };

        for (int i = 0; i <candidats.length ; i++) {
            if(valid(candidats[i], board.length-1, board[0].length-1) && !contains(candidats[i], store) ){
                positions.add(candidats[i]);
            }
        }
        return positions;
    }

    private boolean valid(int[] candidat, int x, int y) {
        return (candidat[0]>=0 && candidat[0]<=x) && (candidat[1]>=0 && candidat[1]<=y);
    }

    private boolean contains(int[] arr, HashSet<ArrayHolder<Integer>> store ) {
        return store.contains(convert(arr));
    }

    private ArrayHolder<Integer> convert(int [] arr) {
        return new ArrayHolder<>(Arrays.stream(arr).boxed().toArray(Integer[]::new ));
    }

    private static class ArrayHolder<T> {

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
            ArrayHolder<T> other = (ArrayHolder<T>) obj;
            if (!Arrays.equals(this.t, other.t)) {
                return false;
            }
            return true;
        }
    }
}
