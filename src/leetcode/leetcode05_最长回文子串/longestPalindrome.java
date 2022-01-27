package leetcode.leetcode05_最长回文子串;

import org.junit.Test;

import java.util.Arrays;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j){
                    dp[i][j] = 1;
                }
                if(j-i == 1 && charArray[j] == charArray[i]){
                    dp[i][j] = 2;
                }
            }
        }
        //先列后行遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(i-j >= 2 && charArray[j] == charArray[i]){
                    if(dp[j+1][i-1] != 0){
                        dp[j][i] = dp[j+1][i-1]+2;
                    }
                }
            }
        }
        int temp_val = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(dp[i][j]>temp_val){
                    res = new String(Arrays.copyOfRange(charArray, i, j+1));
                    temp_val = dp[i][j];
                }
            }
        }
        return res;
    }
    @Test
    public void teat(){
        longestPalindrome("babbad");
    }
}
