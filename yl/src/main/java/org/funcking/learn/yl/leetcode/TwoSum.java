package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class TwoSum extends TestCase {
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if(map.get(num) != null) {
                return new int[]{map.get(num), i};
            }
            
            int minus = target - num;
            
            map.put(minus, i);
        }
        
        return null;
    }
    
    public void test() {
        System.out.println(twoSum(new int[]{1, 5, 10, 15, 16, 19}, 20));
    }
}
