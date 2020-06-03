package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class LongestPalindrome extends TestCase {
    
    public String longestPalindrome(String s) {
        int len = s.length();
        
        int isP[][] = new int[len][len];
        
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0; i < len; i++) {
            isP[i][i] = 1;
            
            if(i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                isP[i][i + 1] = 1;
                maxLeft = i;
                maxRight = i + 1;
            }
        }
        
        for(int i = 2; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                if(s.charAt(j) == s.charAt(i + j)) {
                    isP[j][i + j] = isP[j + 1][i + j - 1] == 1 ? 1 : 0;
                    
                    if(isP[j][i + j] == 1 && maxRight - maxLeft < (i)) {
                        maxRight = i + j;
                        maxLeft = j;
                    }
                }
            }
        }
        
        return s.substring(maxLeft, maxRight + 1);
    }
    
    public void test() {
        System.out.println(longestPalindrome("abcda"));
    }
}
