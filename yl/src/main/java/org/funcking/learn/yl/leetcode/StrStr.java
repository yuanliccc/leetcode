package org.funcking.learn.yl.leetcode;

import junit.framework.Test;
import junit.framework.TestCase;

public class StrStr extends TestCase {
    
    public int strStr(String haystack, String needle) {
        
        if(haystack == null) {
            return -1;
        }
        else if(needle == null || needle.equals("")) {
            return 0;
        }
        
        int index = 0;
        while(index < haystack.length()) {
            while(index < haystack.length() &&
                    haystack.charAt(index) != needle.charAt(0)) {
                index++;
            }
            
            if(index + needle.length() > haystack.length()) {
                return -1;
            }
            
            int i = index;
            boolean isEq = true;
            while(i < index + needle.length()) {
                if(haystack.charAt(i) != needle.charAt(i - index)) {
                    isEq = false;
                    break;
                }
                i++;
            }
            
            if(isEq) return index;
            
            index++;
            
        }
        
        return -1;
    }
    
    public void test() {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hello", "ll"));
    }
    
}
