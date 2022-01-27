package leetcode.leetcode202_¿ìÀÖÊı;

import org.junit.Test;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            n = parseInt(n);
            if(set.contains(n)){
                return false;
            }else{
                set.add(n);
            }
        }
        return true;
    }
    public int parseInt(int n){
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum+=Integer.parseInt(String.valueOf(c)) * Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }
    @Test
    public void test(){
        isHappy(19);
    }
}
