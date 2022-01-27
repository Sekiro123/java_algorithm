package leetcode.leetcode704_¶ş·Ö²éÕÒ;

import org.junit.Test;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (end+start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                end = mid-1;
            }
            if(nums[mid] < target){
                start = mid+1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] nums = new int[]{-1,0,3,5,9,12};
        search(nums,0);
    }
}
