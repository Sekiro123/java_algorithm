package leetcode.leetcode08_×Ö·û´®×ª»»ÕûÊý;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class myatoi {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        boolean ifAppearMarks = false;
        boolean ifAppearNum = false;
        Character[] number = {'0','1','2','3','4','5','6','7','8','9'};
        ArrayList<Character> numbers = new ArrayList<>(Arrays.asList(number));
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if((chars[i] == '-' || chars[i] == '+') && !ifAppearMarks && !ifAppearNum){
                res.add(chars[i]);
                ifAppearMarks = true;
            }
            else if(!numbers.contains(chars[i])){
                break;
            }
            else{
                ifAppearNum = true;
                res.add(chars[i]);
            }
        }
        if(res.size() == 0){
            return 0;
        }
        char mark = ' ';
        if(res.get(0) == '+' || res.get(0) == '-'){
            mark = res.get(0);
            res.remove(0);
        }
        StringBuffer resStringBuffer = new StringBuffer();
        for (Character re : res) {
            resStringBuffer.append(re);
        }
        int resInt = 0;
        if("".equals(resStringBuffer.toString())){
            return 0;
        }
        try {
            resInt = Integer.parseInt(resStringBuffer.toString());
        }catch (NumberFormatException e){
            if(mark == '+' || mark == ' '){
                return 2147483647;
            }
            else{
                return -2147483648;
            }
        }
        if(mark == '+' || mark == ' '){
            return resInt;
        }
        else{
            return -resInt;
        }
    }
    @Test
    public void test(){
        int a = myAtoi("00000-42a1234");
        System.out.println(a);
    }
}
