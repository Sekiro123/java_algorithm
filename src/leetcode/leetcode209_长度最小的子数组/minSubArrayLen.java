package leetcode.leetcode209_长度最小的子数组;

import org.junit.Test;

import java.util.Arrays;

public class minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if(sum(nums) < target){
            return 0;
        }
        int first = 0;
        int second = 1;
        int result = nums.length;
        while (second <= nums.length){
            int[] slice = Arrays.copyOfRange(nums, first, second);
            if(sum(slice) < target){
                second++;
            }
            if(sum(slice) >= target){
                if(second-first < result){
                    result = second-first;
                }
                first++;
            }
        }

        return result;
    }

    public int sum(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        return sum;
    }
    @Test
    public void test(){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        minSubArrayLen(target, nums);
    }
}
