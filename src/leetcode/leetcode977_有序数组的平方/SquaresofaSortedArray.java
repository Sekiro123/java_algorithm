package leetcode.leetcode977_有序数组的平方;

import org.junit.Test;

import java.util.ArrayList;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        ArrayList<Integer> result = new ArrayList<>();
        while (i<=j){
            if(nums[i] * nums[i] >= nums[j] * nums[j]){
                result.add(nums[i] * nums[i]);
                i++;
            }
            else{
                result.add(nums[j] * nums[j]);
                j--;
            }
        }
        int[] res = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            res[k] = result.get(result.size()-k-1);
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums = {-7,-3,2,3,11};
        sortedSquares(nums);
    }
}
