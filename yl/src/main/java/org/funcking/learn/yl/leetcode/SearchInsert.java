package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class SearchInsert extends TestCase {
    
    public int searchInsert(int[] nums, int target) {
        
        int size = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int middle = nums.length / 2;
        
        while(left != right && left + 1 != right) {
            
            if(nums[middle] == target) {
                return middle;
            }
            else if(nums[middle] > target && middle == size - 1) {
                return size;
            }
            else if(nums[middle] > target) {
                right = middle;
                middle = (left + right) / 2;
            }
            else {
                left = middle;
                middle = (left + right) / 2;
            }
        }
        
        if(left + 1 == right) {
            return nums[left] >= target? left : (nums[right] < target ? right + 1 : right);
        }
        
        middle = (left + right) / 2;
        return nums[middle] >= target ? middle : middle + 1;
    }
    
    public void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
    }
    
}
