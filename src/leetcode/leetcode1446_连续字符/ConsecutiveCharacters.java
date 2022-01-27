package leetcode.leetcode1446_连续字符;

import org.junit.Test;

import java.util.ArrayList;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if(s.length() == 0){
            return 0;
        }if(s.length() == 1){
            return 1;
        }
        char[] charArray = s.toCharArray();
        int n = s.length();
        ArrayList<Character> temp_res = new ArrayList<>();
        temp_res.add(charArray[0]);
        ArrayList<Character> res = new ArrayList<>();
        res.add(charArray[0]);
        for (int i = 0; i <n-1; i++) {
            if(charArray[i] == charArray[i+1] && temp_res.get(0) == charArray[i]){
                temp_res.add(charArray[i]);
                if(temp_res.size() > res.size()){
                    res.clear();
                    //复制ArrayList的方法
                    res.addAll(temp_res);
                }
            }
            if(charArray[i] != charArray[i+1]){
                temp_res.clear();
                temp_res.add(charArray[i+1]);
            }
        }
        return res.size();
    }
    @Test
    public void test(){
        maxPower("abbcccddddeeeeedcba");
    }
}
