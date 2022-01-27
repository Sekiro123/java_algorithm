package leetcode.leetcode232_用栈实现队列;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.ObjectOutputStream;
import java.util.Stack;

class MyQueue {
    public Stack<Integer> in = new Stack<>();
    public Stack<Integer> out = new Stack<>();
    public MyQueue() {

    }
    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(!out.empty()) {
            while (in.empty()) {
                int temp = in.pop();
                out.push(temp);
            }
        }
        return out.pop();
    }

    public int peek() {
        if(!out.empty()) {
            while (in.empty()) {
                int temp = in.pop();
                out.push(temp);
            }
        }
        return out.peek();
    }

    public boolean empty() {
        if(in.empty() && out.empty()){
            return true;
        }else{
            return false;
        }
    }
}
