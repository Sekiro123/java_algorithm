package leetcode.leetcode225_用队列实现栈;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public Queue<Integer> in = new LinkedList<>();
    public Queue<Integer> assist = new LinkedList<>();
    public MyStack() {

    }
    public void push(int x) {
        in.add(x);
    }

    public int pop() {
        while (in.size()>1){
            assist.add(in.remove());
        }
        int r = in.remove();
        while (!assist.isEmpty()){
            in.add(assist.remove());
        }
        return r;
    }

    public int top() {
        while (in.size()>1){
            assist.add(in.remove());
        }
        int r = in.element();
        assist.add(in.remove());
        while (!assist.isEmpty()){
            in.add(assist.remove());
        }
        return r;
    }

    public boolean empty() {
        if(in.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
