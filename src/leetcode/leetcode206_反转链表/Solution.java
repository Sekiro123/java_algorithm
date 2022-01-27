package leetcode.leetcode206_·´×ªÁ´±í;

import org.junit.Test;
import leetcode.utils.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode next = head.next;
        current.next = null;
        while (true){
            if(next.next == null){
                next.next = current;
                return next;
            }else{
                ListNode temp = next;
                next = next.next;
                temp.next = current;
                current = temp;
            }
        }
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        ListNode a = ListNode.convert(nums);
        ListNode b = reverseList(a);
        ListNode.print(b);
    }
}
