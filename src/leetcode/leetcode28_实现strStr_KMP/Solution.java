package leetcode.leetcode28_ʵ��strStr_KMP;

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
                //���ǰ��׺��ƥ�䣬Ѱ����һ���ַ���ƥ�䵽�������ǰ��׺��λ�� �ĺ�һ���ַ�
                //����ģʽ������ƥ�䡣
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
