package com.home.task76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 76. Minimum Window Substring
public class Task76Solution {
    public String minWindow(String s, String t) {
        String str = trim(s, t);

        SummaryWindowProcessor summaryWindowProcesor = new SummaryWindowProcessor(t);
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            summaryWindowProcesor.handleCharacter(character, i);
        }

        //get result
        int[] minRange = summaryWindowProcesor.getMinRange();
        String result = "";

        if (minRange[0] !=-1 && minRange[1] != -1) {
            result = str.substring(minRange[0], minRange[1] + 1);
        }

        return result;
    }

    private String trim(String s, String t) {
        int beginIndex = 0;
        int endIndex = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (t.indexOf(c)!=-1) {
                beginIndex = i;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (t.indexOf(c)!=-1) {
                endIndex = i;
                break;
            }
        }
        return s.substring(beginIndex, endIndex + 1);
    }


    // handler
    private static class SummaryWindowProcessor {
        private String window;
        private List<WindowProcessor> windowProcessorList;

        SummaryWindowProcessor(String window) {
            this.window = window;
            this.windowProcessorList = new ArrayList<>();
        }


        int[] getMinRange() {
            List<int[]> processedRangeList = new ArrayList<>();
            int[] minRange = {-1,-1};
            for (WindowProcessor item : windowProcessorList) {
                if (item.processed()) {
                    int[] processedRange = item.getProcessedRange();
                    if(minRange[0]==-1 && minRange[1]==-1){
                        minRange = processedRange;
                    }else{
                        if ((processedRange[1] - processedRange[0]) < (minRange[1] - minRange[0])) {
                            minRange = processedRange;
                        }
                    }

                    processedRangeList.add(item.getProcessedRange());
                }
            }
            return minRange;
        }

        void handleCharacter(Character character, int index) {
            if (this.window.indexOf(character)==-1) {
                return;
            }
            windowProcessorList.add(new WindowProcessor(window.toCharArray(), index));
            for (WindowProcessor processor : windowProcessorList) {
                if (processor.processed()) {
                    continue;
                }
                processor.handle(character, index);
            }
        }

        private static class WindowProcessor {
            private Map<Character, Integer> charMap;
            private Range range;
            private boolean processed;

            WindowProcessor(char[] chars, int index) {
                charMap = createCharMap(chars);
                range = new Range(index);
                processed = false;
            }

            private boolean hasCharacter(Character character) {
                return charMap.containsKey(character);
            }

            private boolean processed() {
                if (!processed) {
                    int summ = 0;
                    for (int value : charMap.values()) {
                        summ += value;
                    }
                    processed = summ == 0;

                }
                return processed;
            }

            void handle(Character character, int index) {
                Integer count = charMap.get(character);
                count = count - 1 >= 0 ? count - 1 : 0;
                charMap.put(character, count);
                if (processed()) {
                    this.range.close(index);
                }
            }

            private Map<Character, Integer> createCharMap(char[] chars) {
                Map<Character, Integer> characterMap = new HashMap<>();
                for (int i = 0; i < chars.length; i++) {
                    if (!characterMap.containsKey(chars[i])) {
                        characterMap.put(chars[i], 0);
                    }
                    Integer count = characterMap.get(chars[i]);
                    characterMap.put(chars[i], ++count);
                }
                return characterMap;
            }

            int[] getProcessedRange() {
                return this.range.getRange();
            }

            private static class Range {
                private int startIndex;
                private int endIndex;

                Range(int startIndex) {
                    this.startIndex = startIndex;
                    this.endIndex = -1;
                }

                Range(int startIndex, int endIndex) {
                    this.startIndex = startIndex;
                    this.endIndex = endIndex;
                }

                public void close(int endIndex) {
                    this.endIndex = endIndex;
                }

                boolean closed() {
                    return startIndex != -1 && endIndex != -1;
                }

                int[] getRange() {
                    return new int[]{startIndex, endIndex};
                }
            }
        }
    }
}
