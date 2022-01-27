package leetcode.leetcode1_����֮��;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //��target������Ԫ��֮����Ϊkey��Ԫ��������Ϊvalue
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsValue(target-nums[i])){
                return new int[]{i, findKey(map, target - nums[i])};
            }else{
                map.put(i, nums[i]);
            }
        }
        return new int[]{1,1};
    }
    public int findKey(HashMap<Integer, Integer> map, int value){
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if(i.getValue() == value){
                return i.getKey();
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int[]result = twoSum(nums, 9);
    }
}
