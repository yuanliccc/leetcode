package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

import java.util.Stack;

public class DecodeString extends TestCase {
    
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack();
        char[] sArr = s.toCharArray();
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        
        while(index < sArr.length) {
            
            while(index < sArr.length && sArr[index] != ']') {
                if(sArr[index] == '[') {
                    index++;
                    stack.push("[");
                }
                else if(sArr[index] >= '0' && sArr[index] <= '9'){
                    StringBuilder num = new StringBuilder();
                    while(index < sArr.length &&
                            sArr[index] >= '0' && sArr[index] <= '9') {
                        num.append(sArr[index]);
                        index++;
                    }
                    stack.push(num.toString());
                }
                else {
                    StringBuilder word = new StringBuilder();
                    while(index < sArr.length && sArr[index] != '[' &&
                            sArr[index] != ']' &&
                            (sArr[index] < '0' || sArr[index] > '9')) {
                        word.append(sArr[index]);
                        index++;
                    }
                    stack.push(word.toString());
                }
            }
            if(index >= sArr.length) {
                break;
            }
            if(sArr[index] == ']') {
                StringBuilder word = new StringBuilder();
                
                Stack<String> wordStack = new Stack();
                while(!stack.isEmpty() &&
                        (stack.peek().charAt(0) < '0' || stack.peek().charAt(0) > '9') &&
                        stack.peek().charAt(0) != '[') {
                    wordStack.push(stack.pop());
                }
                
                while(!wordStack.isEmpty()) {
                    word.append(wordStack.pop());
                }
                
                if(stack.peek().equals("[")) {
                    stack.pop();
                }
                int num = strToInt(stack.pop());
                String nWords = nString(word.toString(), num);
                
                stack.push(nWords);
                index++;
            }
        }
        
        StringBuilder rs = new StringBuilder();
        Stack<String> wordStack = new Stack();
        while(!stack.isEmpty()) {
            wordStack.push(stack.pop());
        }
        
        while(!wordStack.isEmpty()) {
            rs.append(wordStack.pop());
        }
        
        return rs.toString();
        
    }
    
    public String nString(String word, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            sb.append(word);
        }
        return sb.toString();
    }
    
    public int strToInt(String num) {
        int rs = 0;
        
        for(int i = 0; i < num.length(); i++) {
            rs = rs * 10 + (num.charAt(i) - '0');
        }
        
        return rs;
    }
    
    public void test() {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
    
}
