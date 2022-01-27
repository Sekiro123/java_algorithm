package leetcode.leetcode15_三数之和;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if(map.containsKey(sum)){
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    map.get(sum).add(index);
                }else{
                    List<List<Integer>> list = new ArrayList<>();
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    list.add(index);
                    map.put(sum, list);
                }
            }
        }
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(-nums[i])){
                List<List<Integer>> list = map.get(-nums[i]);
                for (List<Integer> index : list) {
                    if(!index.contains(i)){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[index.get(0)]);
                        res.add(nums[index.get(1)]);
                        res.sort(Comparator.reverseOrder());
                        result.add(res);
                    }
                }
            }
        }
        int a = 1;
        return new ArrayList<>(result);
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                if(nums[i] + nums[right] + nums[left] < 0){
                    left++;
                }
                else if(nums[i] + nums[right] + nums[left] > 0){
                    right--;
                }
                else{
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    set.add(res);
                    left++;
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum2(nums);
    }
}
