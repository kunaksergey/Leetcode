package com.home.task79;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Task79SolutionTest {
    private Task79Solution solution;

    @Before
    public void before(){
        this.solution = new Task79Solution();
    }

    @Test
    public void test1() {
        char[][] input = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = true;
        assertThat(solution.exist(input, word), is(result));
    }

        @Test
        public void test2 () {
            char[][] input ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            String word = "SEE";
            boolean result = true;
            assertThat(solution.exist(input, word), is(result));
        }

        @Test
        public void test3 () {
            char[][] input = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            String word = "ABCB";
            boolean result = false;
            assertThat(solution.exist(input, word), is(result));
        }
    }
