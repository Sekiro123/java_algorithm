package leetcode.leetcode20_ÓÐÐ§µÄÀ¨ºÅ;

import com.sun.javafx.image.BytePixelSetter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Character[] left = {'(','{','['};
        List<Character> leftList = Arrays.asList(left);
        List<Character> rightList = Arrays.asList('}',')',']');
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(leftList.contains(new Character(c))){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                }
                else if(stack.peek() == '{' && c == '}'){
                    stack.pop();
                }
                else if(stack.peek() == '[' && c == ']'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    @Test
    public void test(){
        isValid("()");
    }
}
