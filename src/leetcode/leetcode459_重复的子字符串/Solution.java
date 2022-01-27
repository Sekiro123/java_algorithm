package leetcode.leetcode459_�ظ������ַ���;

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
}
