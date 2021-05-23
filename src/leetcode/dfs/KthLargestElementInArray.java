package leetcode.dfs;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    //快速选择算法
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, k, 0, nums.length-1);
    }
    public int quickselect(int[] nums, int k, int start, int end){
        int temp = quicksort(nums,start,end);
        if(temp == nums.length-k){
            return nums[temp];
        }
        else if(temp > nums.length-k){
            return quickselect(nums, k, start, temp-1);
        }
        else{
            return quickselect(nums, k, temp+1, end);
        }
    }
    public int quicksort(int[] nums, int start, int end){
        int low = start;
        int temp = nums[start];
        while(start < end){
            while(nums[end] >= temp && start < end){
                end--;
            }
            while(nums[start] <= temp && start < end){
                start++;
            }
            if(start < end){
                swap(nums, start, end);
            }
        }
        swap(nums, low, start);
        return start;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //优先队列算法
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> maxk = new PriorityQueue<Integer>((p1, p2)->p1-p2);
        for (int i = 0; i < nums.length; i++) {
            if(maxk.size() >= k){
                maxk.add(nums[i]);
                maxk.poll();
            }else{
                maxk.add(nums[i]);
            }
        }
        System.out.println("123");
        System.out.println("second");
        System.out.println("hotfix");
        System.out.println("master");
        System.out.println("push test");
        return maxk.peek();
    }
}
