package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class Multiply extends TestCase {
    public String multiply(String num1, String num2) {
        
        if(num1 == null || num2 == null) {
            return "";
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        char rs[] = null;
        
        if(len1 > len2) {
            rs = multiplyTwo(num1.toCharArray(), num2.toCharArray());
        }
        else {
            rs = multiplyTwo(num2.toCharArray(), num1.toCharArray());
        }
        
        int index = 0;
        while(index < rs.length && !(rs[index] > '0' && rs[index] <= '9')) {
            index++;
        }
        
        if(index == rs.length) {
            return "0";
        }
        
        char[] realRs = new char[rs.length - index];
        
        System.arraycopy(rs, index, realRs, 0, realRs.length);
        
        return new String(realRs);
    }
    
    private char[] multiplyTwo(char[] longest, char[] shortest) {
        char rs[][] = new char[shortest.length][];
        
        for(int i = shortest.length - 1; i >= 0; i--) {
            char[] num = new char[longest.length + shortest.length - i];
            init(num);
            char[] charM = multiplyChar(longest, shortest[i]);
            System.arraycopy(charM, 0, num, 0, charM.length);
            rs[i] = num;
        }
        
        return add(rs);
    }
    
    private void init(char[] chars) {
        for(int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }
    }
    
    private char[] add(char[][] nums) {
        char[] rs = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            rs = add(rs, nums[i]);
        }
        
        return rs;
    }
    
    private char[] add(char[] num1, char[] num2) {
        int len = num1.length > num2.length ? num1.length : num2.length;
        char[] num1Tmp = new char[len];
        init(num1Tmp);
        System.arraycopy(num1, 0, num1Tmp, len - num1.length, num1.length);
        
        char[] num2Tmp = new char[len];
        init(num2Tmp);
        System.arraycopy(num2, 0, num2Tmp, len - num2.length, num2.length);
        
        char[] rs = new char[len + 1];
        init(rs);
        int index = len;
        int up = 0;
        
        for(int i = len - 1; i >= 0; i--) {
            int sum = (num1Tmp[i] - '0') + (num2Tmp[i] - '0') + up;
            
            if(sum < 10) {
                rs[index--] = (char)(sum + '0');
                up = 0;
            }
            else {
                up = 1;
                rs[index--] = (char)(sum % 10 + '0');
            }
        }
        
        if(up == 1) {
            rs[0] = 1;
        }
        
        return rs;
    }
    
    private char[] multiplyChar(char[] num, char c) {
        char[] rs = new char[num.length + 1];
        init(rs);
        int cNum = c - '0';
        
        if(cNum == 0) {
            return new char[]{'0'};
        }
        
        int up = 0;
        int index = num.length;
        for(int i = num.length - 1; i >= 0; i--) {
            char cc = num[i];
            int ccNum = cc - '0';
            
            int mNum = ccNum * cNum + up;
            
            if(mNum < 10) {
                rs[index--] = (char)(mNum + '0');
                up = 0;
            }
            else {
                rs[index--] = (char)(mNum % 10 + '0');
                up = mNum / 10;
            }
        }
        
        if(up != 0) {
            rs[0] = (char)(up + '0');
        }
        
        return rs;
    }
    
    public void test() {
        System.out.println(multiply("140", "721"));
    }
}
