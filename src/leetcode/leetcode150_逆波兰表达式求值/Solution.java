package leetcode.leetcode150_逆波兰表达式求值;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] operaters = {"+","-","*","/"};
        for (String s : tokens) {
            if(!Arrays.asList(operaters).contains(s)){
                stack.push(s);
            }
            else if("+".equals(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b+a));
            }
            else if("-".equals(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b-a));
            }
            else if("*".equals(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b*a));
            }
            else if("/".equals(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b/a));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
