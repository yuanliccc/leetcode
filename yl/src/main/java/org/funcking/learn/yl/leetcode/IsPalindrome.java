package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome extends TestCase {
    
    public boolean isPalindrome(String s) {
        
        if(s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            while(left < right && !is(s.charAt(left))) {
                left++;
            }
            
            while(right > left && !is(s.charAt(right))) {
                right--;
            }
            
            if(left < right) {
                if(!isEquals(s.charAt(left), s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
            else {
                break;
            }
        }
        
        return true;
    }
    
    private boolean isEquals(char c1, char c2) {
        if(c1 >= '0' && c1 <= '9') {
            if(c2 >= '0' && c2 <= '9') {
                return c1 == c2;
            }
            else {
                return false;
            }
        }
        else {
            if(c2 >= '0' && c2 <= '9') {
                return false;
            }
            else {
                if(c1 >= 'a' && c1 <= 'z') {
                    if(c2 >= 'a' && c2 <= 'z') {
                        return c1 == c2;
                    }
                    else {
                        return c1 - 'a' == c2 - 'A';
                    }
                }
                else {
                    if(c2 >= 'a' && c2 <= 'z') {
                        return c1 - 'A' == c2 - 'a';
                    }
                    else {
                        return c1 == c2;
                    }
                }
            }
        }
    }
    
    
    private boolean is(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }
    
    public void test() {
        System.out.println(isPalindrome("0P"));
    }
}
