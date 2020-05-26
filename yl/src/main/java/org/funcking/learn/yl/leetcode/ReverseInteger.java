package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class ReverseInteger extends TestCase {
    
    public int reverse(int x) {
        
        boolean sign = x > 0;
        
        if(x > -10 && x < 10) {
            return x;
        }
        
        x = sign ? x : x * -1;
        int num = 0;
        
        while(x / 10.0 > 0) {
            int tmp = x % 10;
            // 判断是否溢出
            if(sign && num > ((Integer.MAX_VALUE - tmp) / 10 )) {
                num = 0;
                break;
            }
            else if(!sign && num > ((Integer.MIN_VALUE + tmp) / 10 * -1)) {
                num = 0;
                break;
            }
            num = num * 10 + tmp;
            x = x / 10;
        }
        
        return sign ? num : num * -1;
    }
    
    public void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

}
