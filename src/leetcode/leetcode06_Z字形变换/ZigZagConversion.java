package leetcode.leetcode06_Z×ÖÐÎ±ä»»;

import org.junit.Test;

import java.util.ArrayList;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        ArrayList<ArrayList<Character>> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<Character>());
        }
        int n = 2*numRows-2;
        for (int i = 0; i < s.length(); i++) {
            if(i%n == 0){
                res.get(0).add(charArray[i]);
            }
            if(i%n == numRows-1){
                res.get(numRows-1).add(charArray[i]);
            }
            for (int j = 1; j < numRows-1; j++) {
                if(i%n == j || i%n == n-j){
                    res.get(j).add(charArray[i]);
                }
            }
        }
        StringBuffer result = new StringBuffer();
        for (ArrayList<Character> re : res) {
            for (Character character : re) {
                result.append(character);
            }
        }
        return result.toString();
    }


    @Test
    public void test(){
        String a = convert("abcdefghij", 2);
        System.out.println(a);
    }
}
