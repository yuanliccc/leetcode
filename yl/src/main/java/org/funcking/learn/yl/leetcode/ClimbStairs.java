package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class ClimbStairs extends TestCase {
    
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int befBef = 1;
        int bef = 2;
        while(n > 2) {
            int tmp = bef + befBef;
            befBef = bef;
            bef = tmp;
            n--;
        }
        return bef;
    }
    
    public void test() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
