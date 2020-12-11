package com.home.task169;

import java.util.HashMap;
import java.util.Map;
// 169. Majority Element
public class Task169Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
          if(!map.containsKey(nums[i])){
              map.put(nums[i], 0);
            }
          Integer count = map.get(nums[i]);
          if(count+1> nums.length/2){
              return nums[i];
          }else{
              map.put(nums[i], ++count);
          }
        }
        return 0;
    }
}
