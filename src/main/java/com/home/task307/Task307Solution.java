package com.home.task307;

//307. Range Sum Query - Mutable
public class Task307Solution {
        private int[] nums_;
        public Task307Solution(int[] nums) {
            this.nums_ = nums;
        }

        public void update(int i, int val) {
            if(i<0 || i> nums_.length-1) return;
            nums_[i] = val;
        }

        public int sumRange(int i, int j) {
            int summ = 0;
            if(i<0 || i> nums_.length-1) return 0;
            if(j<0 || j> nums_.length-1) return 0;
            if(i>j) return  0;
            for (int k = i; k <=j ; k++) {
                summ+=nums_[k];
            }
            return summ;
        }
    }

