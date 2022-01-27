package leetcode.leetcode459_重复的子字符串;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNext(s);
        if(s.length()%(s.length()-next[next.length-1]) == 0){
            return true;
        }
        return false;
    }
    public int[] getNext(String s){
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        result[0] = 0;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            while(j>0 && chars[j] != chars[i]){
                //如果前后缀不匹配，寻找上一个字符所匹配到的最长公共前后缀的位置 的后一个字符
                //再与模式串继续匹配。
                j = result[j-1];
            }
            if(chars[j] == chars[i]){
                j++;
            }
            result[i] = j;
        }
        return result;
    }
}
