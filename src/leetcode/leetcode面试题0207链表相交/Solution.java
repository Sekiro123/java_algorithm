package leetcode.leetcode面试题0207链表相交;

import leetcode.utils.ListNode;

import java.util.HashMap;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (headA != null){
            map.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null){
            if (map.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
