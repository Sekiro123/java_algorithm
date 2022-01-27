package leetcode.leetcode19_删除链表的倒数第N个结点;

import leetcode.utils.ListNode;
import org.junit.Test;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = new ListNode(1, head);
        ListNode prehead = p1;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return prehead.next;
    }
    @Test
    public void test(){
        int[] nums = {1,2,3};
        ListNode head = ListNode.convert(nums);
        ListNode a = removeNthFromEnd(head,1);
        ListNode.print(a);
    }
}
