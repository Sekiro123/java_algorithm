package leetcode.leetcode239_滑动窗口最大值;

import org.junit.Test;

import java.util.*;

class Myqueue {
    public LinkedList<Integer> queue = new LinkedList<>();
    public void pop(int val){
        if(!queue.isEmpty() && queue.getFirst() == val){
            queue.pollFirst();
        }
    }
    public void push(int val){
        while (!queue.isEmpty() && val > queue.getLast()){
            queue.pollLast();
        }
        queue.addLast(val);
    }
    public int front(){
        return queue.getFirst();
    }
}
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Myqueue queue = new Myqueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(queue.front());
        for (int i = 0; i < nums.length-k; i++) {
            queue.pop(nums[i]);
            queue.push(nums[i+k]);
            result.add(queue.front());
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    @Test
    public void test(){
        int[] nums = {7,2,4};
        maxSlidingWindow(nums, 2);
    }
}
