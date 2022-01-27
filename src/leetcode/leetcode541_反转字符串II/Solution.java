package leetcode.leetcode541_·´×ª×Ö·û´®II;

import org.junit.Test;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length()];
        for (int i = 0; (i+1)*2*k <= s.length(); i+=1) {
            int left = i*2*k;
            int right = i*2*k+k-1;
            while (left <= right){
                if(left == right){
                    res[left] = chars[left];
                    left++;
                    break;
                }
                res[left] = chars[right];
                res[right] = chars[left];
                left++;
                right--;
            }
            for (int j = i*2*k+k; j < i*2*k+2*k; j++) {
                res[j] = chars[j];
            }
        }
        int round = s.length() / (2*k);
        int rest = s.length()-round*2*k;
        if(rest == 0){
            return new String(res);
        }
        if(rest <= k){
            int left = round*2*k;
            int right = s.length()-1;
            while (left <= right){
                if(left == right){
                    res[left] = chars[left];
                    left++;
                    break;
                }
                res[left] = chars[right];
                res[right] = chars[left];
                left++;
                right--;
            }
        }
        if(rest > k){
            int left = round*2*k;
            int right = round*2*k+k-1;
            while (left <= right) {
                if (left == right) {
                    res[left] = chars[left];
                    left++;
                    break;
                }
                res[left] = chars[right];
                res[right] = chars[left];
                left++;
                right--;
            }
            for (int i = round*2*k+k; i < s.length(); i++) {
                res[i] = chars[i];
            }
        }
        return new String(res);
    }
    @Test
    public void test(){
        String s = "1234";
        reverseStr(s, 2);
    }
}
