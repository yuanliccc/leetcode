package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

/**
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1: 输入: 4 输出: 2
 * 示例 2: 输入: 8 输出: 2
 *
 * 说明:
 * 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrt extends TestCase {
    
    public int mySqrt(int x) {
        
        if(x == 1) {
            return 1;
        }
        
        double left = 0d;
        double right = x;
        
        while(left < right) {
            double middle = (left + right) / 2.0;
            
            if((int)(x / middle) == (int)middle) {
                break;
            }
            else if((int)(x / middle) >= (int)middle) {
                left = middle;
            }
            else {
                right = middle;
            }
        }
        
        return (int)(left + right) / 2;
    }
    
    public void test() {
        System.out.println(mySqrt(100));
        System.out.println(mySqrt(8));
    }
}
