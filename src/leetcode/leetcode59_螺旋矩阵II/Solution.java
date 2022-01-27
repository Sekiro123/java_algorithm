package leetcode.leetcode59_ÂİĞı¾ØÕóII;

import org.junit.Test;

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 1){
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];
        int round = (n+1)/2;
        int col = n;
        int tempVal = 1;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < col-1; j++) {
                result[i][j+i] = tempVal;
                tempVal++;
            }
            for (int j = 0; j < col-1; j++) {
                result[j+i][n-i-1] = tempVal;
                tempVal++;
            }
            for (int j = 0; j < col-1; j++) {
                result[n-i-1][n-j-1-i] = tempVal;
                tempVal++;
            }
            for (int j = 0; j < col-1; j++) {
                result[n-j-1-i][i] = tempVal;
                tempVal++;
            }
            if(tempVal == n*n+1){
                return result;
            }
            col-=2;
            if(col == 1){
                result[n/2][n/2] = n*n;
                return result;
            }
        }
        return result;
    }
    @Test
    public void test(){
        generateMatrix(5);
    }
}
