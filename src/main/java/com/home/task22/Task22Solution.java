package com.home.task22;

import java.util.*;
import java.util.stream.Collectors;

// 22. Generate Parentheses
public class Task22Solution {

    public List<String> generateParenthesis(int n) {
        String parenthesis = "()";
        Set<String> resultSet = new HashSet<>();
        resultSet.add(parenthesis);

        for (int i = 0; i <n-1; i++) {
            final int lengthForFilter = (i+1)*2;
            Set<String> filteredByLength = resultSet.stream().filter(str -> str.length() == lengthForFilter).collect(Collectors.toSet());
            for (String str: filteredByLength) {
                for (int j = 1; j <str.length() ; j++) {
                    String left = str.substring(0,j);
                    String right = str.substring(j);
                    resultSet.add(left+parenthesis+right);
                }
                resultSet.add(parenthesis+str);
                resultSet.add(str+parenthesis);
            }
        }
        List<String> result = new ArrayList<>(resultSet.stream().filter(str->str.length()==n*2).collect(Collectors.toList()));
        return result;
    }

}

