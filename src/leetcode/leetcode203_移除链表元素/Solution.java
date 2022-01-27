package leetcode.leetcode203_ÒÆ³ýÁ´±íÔªËØ;

import org.junit.Test;
import leetcode.utils.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(-1, head);
        ListNode result = p;
        while(p.next != null){
            if(p.next.val == val && p.next.next != null){
                ListNode q = p.next.next;
                p.next = q;
            }
            else if(p.next.val == val && p.next.next == null){
                p.next = null;
            }
            else{
                p = p.next;
            }
        }
        return result.next;
    }
    @Test
    public void test(){
        int[] nums = {1,2,1,3};
        ListNode head = ListNode.convert(nums);
        ListNode a = removeElements(head, 1);
        ListNode.print(a);
    }
}
