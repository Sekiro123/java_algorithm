package leetcode.dfs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ReverseLinklistInKgorup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        ArrayList<ArrayList<ListNode>> splitnode = splitLinkList(head, k);
        for (ArrayList<ListNode> i : splitnode) {
            if(i.size() == k){
                ListNode next_head = findNode(i.get(k-1), k);
                ListNode temp_head = i.get(0);
                for (int j = 0; j < k-1; j++) {
                    i.get(j+1).next = i.get(j);
                }
                temp_head.next = next_head;
            }
            else{
                splitnode.get(splitnode.size()-2).get(0).next = i.get(0);
            }
        }

        return splitnode.get(0).get(k-1);
    }

    public ListNode findNode(ListNode n, int k){
        for (int i = 0; i < k; i++) {
            if(n.next != null){
                n = n.next;
            }else{
                return null;
            }
        }
        return n;
    }

    public ArrayList<ArrayList<ListNode>> splitLinkList(ListNode head, int k){
        ArrayList<ArrayList<ListNode>> splitnode = new ArrayList<>();
        ArrayList<ListNode> listnode = new ArrayList<>();
        boolean tag = true;
        while(tag){
            for (int i = 0; i < k; i++) {
                if(head != null){
                    listnode.add(head);
                    head = head.next;
                }else{
                    tag = false;
                }
            }
            if(listnode.size() != 0){
                splitnode.add(new ArrayList<>(listnode));
            }
            listnode.clear();
        }
        PriorityQueue<Integer> maxk = new PriorityQueue<Integer>((p1, p2)->p1-p2);
        return splitnode;
    }
}
