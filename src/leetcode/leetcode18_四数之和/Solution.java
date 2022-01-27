package leetcode.leetcode18_四数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set= new HashSet<>();
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int left = j+1;
                int right = nums.length-1;
                while (left < right){
                    if(nums[i] + nums[j] + nums[left] + nums[right] < target){
                        left++;
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }else{
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        right--;
                        left++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    @Test
    public void test(){
        int[] nums = {1,0,-1,0,-2,2};
        fourSum(nums, 0);
    }
}
