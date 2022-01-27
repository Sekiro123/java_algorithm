package leetcode.utils;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode convert(int[] nums){
        ListNode listNode = new ListNode(nums[0]);
        ListNode head = listNode;
        for (int i = 1; i < nums.length; i++) {
            ListNode a = new ListNode(nums[i]);
            listNode.next = a;
            listNode = listNode.next;
        }
        return head;
    }

    public static void print(ListNode head){
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null){
            nums.add(head.val);
            head = head.next;
        }
        System.out.println(nums);
    }
}
