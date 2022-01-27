package leetcode.leetcode142_ª∑–Œ¡¥±ÌII;

import leetcode.utils.ListNode;

import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null){
            if(!listNodes.contains(head)){
                listNodes.add(head);
            }
            else{
                return head;
            }
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode meet = null;
        while(p2 != null){
            if(p2.next != null){
                p2 = p2.next.next;
            }else{
                return null;
            }
            p1 = p1.next;
            if(p1 == p2){
                meet = p1;
                break;
            }
        }
        if(p2 == null){
            return null;
        }
        ListNode q1 = head;
        ListNode q2 = meet;
        while(q1 != q2){
            q1 = q1.next;
            q2 = q2.next;
        }
        return q1;
    }
}
