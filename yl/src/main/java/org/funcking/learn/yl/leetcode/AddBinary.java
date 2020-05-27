package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary extends TestCase {
    
    public String addBinary(String a, String b) {
        if(a == null || b == null) {
            return a == null ? b : a;
        }
        
        if(a.equals("") || b.equals("")) {
            return a.equals("") ? b : a;
        }
        
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        int aIndex = aArr.length - 1;
        int bIndex = bArr.length - 1;
        
        char[] rs = new char[aIndex > bIndex ? aIndex + 1 : bIndex + 1];
        int rsIndex = rs.length - 1;
        
        boolean isPlus = false;
        
        while(aIndex >= 0 || bIndex >= 0) {
            if((aIndex < 0 && bIndex >= 0) || (aIndex >= 0 && bIndex < 0)) {
                int index = aIndex >= 0 ? aIndex : bIndex;
                char[] arr = aIndex >= 0 ? aArr : bArr;
                
                while (index >= 0) {
                    if(isPlus) {
                        isPlus = arr[index] == '1';
                        rs[rsIndex--] = arr[index] == '1' ? '0' : '1';
                    }
                    else {
                        isPlus = false;
                        rs[rsIndex--] = arr[index];
                    }
                    index--;
                }
                aIndex = -1;
                bIndex = -1;
            }
            else {
                char aChar = aArr[aIndex];
                char bChar = bArr[bIndex];
                
                if(aChar == bChar && aChar == '1') {
                    if(isPlus) {
                        rs[rsIndex--] = '1';
                    }
                    else {
                        rs[rsIndex--] = '0';
                    }
                    isPlus = true;
                }
                else if(aChar == bChar && aChar == '0') {
                    if(isPlus) {
                        rs[rsIndex--] = '1';
                    }
                    else {
                        rs[rsIndex--] = '0';
                    }
                    isPlus = false;
                }
                else {
                    if(isPlus) {
                        rs[rsIndex--] = '0';
                        isPlus = true;
                    }
                    else {
                        rs[rsIndex--] = '1';
                        isPlus = false;
                    }
                }
                aIndex--;
                bIndex--;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        if(isPlus) sb.append('1');
        for(int i = 0; i < rs.length; i++) {
            sb.append(rs[i]);
        }
        
        return sb.toString();
    }
    
    public void test() {
        System.out.println(addBinary("101111", "10"));
    }
    
}
