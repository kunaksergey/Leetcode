package com.home.task17;

import java.util.*;
import java.util.stream.Collectors;

//7. Letter Combinations of a Phone Number
public class Task17Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, Character[]> phoneNumbers = createPhoneNumberLetters();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <digits.length() ; i++) {
            result = combine(phoneNumbers.get(digits.charAt(i)), result);
        }
        return result;
    }

    private Map<Character, Character[]> createPhoneNumberLetters() {
        Map<Character, Character[]> phoneNumbers = new HashMap<>();
        phoneNumbers.put('2', new Character[] {'a', 'b', 'c'});
        phoneNumbers.put('3', new Character[] {'d', 'e', 'f'});
        phoneNumbers.put('4', new Character[] {'g', 'h', 'i'});
        phoneNumbers.put('5', new Character[] {'j', 'k', 'l'});
        phoneNumbers.put('6', new Character[] {'m', 'n', 'o'});
        phoneNumbers.put('7', new Character[] {'p', 'q', 'r', 's'});
        phoneNumbers.put('8', new Character[] {'t', 'u', 'v'});
        phoneNumbers.put('9', new Character[] {'w', 'x', 'y', 'z'});
        return phoneNumbers;
    }

    private List<String> combine(Character [] charArr, List<String> combinedList ) {
        if(combinedList.isEmpty()){
            return Arrays.stream(charArr).map(char_->char_.toString()).collect(Collectors.toList());
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i <combinedList.size() ; i++) {
            for (int j = 0; j <charArr.length ; j++) {
                result.add(combinedList.get(i)+charArr[j]);
            }

        }
        return result;
    }

}
