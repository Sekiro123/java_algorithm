package leetcode.leetcode347_前K个高频元素;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        List<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        })).collect(Collectors.toList());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sorted.get(i).getKey();
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        topKFrequent(nums, 2);
    }
}
