package leetcode.leetcode27_ÒÆ³ıÔªËØ;

import org.junit.Test;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == val) {
                for (int j = i; j < len-1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                len--;
                i--;
            }
        }
        return len;
    }
    public int removeElement2(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast<nums.length){
            if(nums[fast] == val){
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
            if(fast>=nums.length){
                return slow;
            }
        }
        return slow;
    }
    @Test
    public void test(){
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement2(nums,2);
    }
}
