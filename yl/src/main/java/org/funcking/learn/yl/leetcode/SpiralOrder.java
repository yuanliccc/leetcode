package org.funcking.learn.yl.leetcode;

import junit.framework.TestCase;

public class SpiralOrder extends TestCase {
    
    public int[] spiralOrder(int[][] matrix) {
        
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        
        int rowIndex = 0;
        int columnIndex = 0;
        
        int index = 0;
        int[] rs = new int[matrix.length * matrix[0].length];
        
        while(true) {
            boolean is = false;
            while(columnIndex <= right) {
                rs[index++] = matrix[rowIndex][columnIndex++];
                is = true;
            }
            
            if(is) {
                columnIndex--;
                up++;
                rowIndex++;
            }
            
            if(up > down) {
                up--;
                break;
            }
            
            is = false;
            
            while(rowIndex <= down) {
                rs[index++] = matrix[rowIndex++][columnIndex];
                is = true;
            }
            if(is) {
                rowIndex--;
                right--;
                columnIndex--;
            }
            
            if(right < left) {
                right++;
                break;
            }
            
            is = false;
            while(columnIndex >= left) {
                rs[index++] = matrix[rowIndex][columnIndex--];
                is = true;
            }
            if(is) {
                columnIndex++;
                down--;
                rowIndex--;
            }
            
            if(down < up) {
                down++;
                break;
            }
            
            is = false;
            while(rowIndex >= up) {
                rs[index++] = matrix[rowIndex--][columnIndex];
                is = true;
            }
            if(is) {
                rowIndex++;
                left++;
                columnIndex++;
            }
            
            if(left > right) {
                left--;
                break;
            }
        }
        
        return rs;
    }
    
    public void test() {
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
