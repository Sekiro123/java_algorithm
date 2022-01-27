package leetcode.leetcode28_实现strStr_KMP;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
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
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = 0;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            while (chars1[i] != chars2[j] && j>0){
                j = next[j-1];
            }
            if(chars1[i] == chars2[j]){
                j++;
            }
            if(j == needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        String haystack = "ababababac", needle = "ababac";
        strStr(haystack,needle);
        Arrays.stream(getNext("aaabac")).forEach(System.out::println);
    }
}
