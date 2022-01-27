package leetcode.leetcode1047_删除字符串中的所有相邻重复项;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
