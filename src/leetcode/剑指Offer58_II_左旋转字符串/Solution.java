package leetcode.��ָOffer58_II_����ת�ַ���;

import sun.security.util.Length;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuffer result = new StringBuffer();
        result.append(s,n,len);
        result.append(s,0,n);
        return result.toString();
    }
}
