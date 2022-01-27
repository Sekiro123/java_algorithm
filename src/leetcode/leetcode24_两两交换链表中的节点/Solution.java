package leetcode.leetcode24_两两交换链表中的节点;

import leetcode.utils.ListNode;
import org.junit.Test;

import java.awt.font.NumericShaper;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode preHead  = new ListNode(-1,head);
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p0 = preHead;
        while (true){
            p0.next = p2;
            ListNode temp = p2.next;
            p2.next = p1;
            p1.next = temp;
            if(temp == null || temp.next == null){
                return preHead.next;
            }
            p0 = p1;
            p1 = temp;
            p2 = temp.next;
        }
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = ListNode.convert(nums);
        ListNode a = swapPairs(head);
        ListNode.print(a);
    }
}
