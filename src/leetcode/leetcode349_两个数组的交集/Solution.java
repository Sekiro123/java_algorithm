package leetcode.leetcode349_��������Ľ���;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
