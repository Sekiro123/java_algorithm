package leetcode.leetcode151_翻转字符串里的单词;

import org.junit.Test;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int left = s.length()-1;
        int right = s.length()-1;
        while(left >= 0){
            if(left == right && chars[left] == ' '){
                left--;
                right--;
            }
            else if(left == 0 && chars[right] != ' '){
                result.append(s, left, right+1);
                left--;
            }
            else if(chars[left] != ' '){
                left--;
            }
            else if(left != right && chars[left] == ' '){
                result.append(s, left+1, right+1);
                result.append(' ');
                left--;
                right = left;
            }
        }
        return result.toString().trim();
    }
    public String reverseStr(String s){
        return new StringBuffer(s).reverse().toString();
    }
    @Test
    public void rest(){
        reverseWords(" asdasd df f");
    }
}
