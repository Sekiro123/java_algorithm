package leetcode.leetcode454_四数相加II;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //两个map，元素之和作为key，元素之和出现的次数作为value。
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map12 = new HashMap<>();
        HashMap<Integer, Integer> map34 = new HashMap<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = nums1[i] + nums2[j];
                if(map12.containsKey(count)){
                    map12.put(count,map12.get(count)+1);
                }else{
                    map12.put(count, 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = nums3[i] + nums4[j];
                if(map34.containsKey(count)){
                    map34.put(count,map34.get(count)+1);
                }else{
                    map34.put(count, 1);
                }
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map12.entrySet()) {
            if(map34.containsKey(-entry.getKey())){
                result += map34.get(-entry.getKey()) * entry.getValue();
            }
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-1,-2};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};
        fourSumCount(nums1,nums2,nums3,nums4);
    }

}
