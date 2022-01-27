package leetcode.½£Ö¸Offer05_Ìæ»»¿Õ¸ñ;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import sun.security.util.math.ImmutableIntegerModuloP;

import java.security.SecureRandom;

public class Solution {
    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        int spaceNum = 0;
        for (char c : charArray) {
            if(c == ' '){
                spaceNum++;
            }
        }
        char[] result = new char[s.length() + spaceNum * 2];
        int left = s.length()-1;
        int right = result.length-1;
        while (left < right){
            if(charArray[left] != ' '){
                result[right] = charArray[left];
                right--;
                left--;
            }
            else{
                result[right--] = '0';
                result[right--] = '2';
                result[right--] = '%';
                left--;
            }
        }
        for (int i = 0; i < left+1; i++) {
            result[i] = charArray[i];
        }
        return new String(result);
    }
    @Test
    public void test(){
        replaceSpace("We are happy.");
    }
}
