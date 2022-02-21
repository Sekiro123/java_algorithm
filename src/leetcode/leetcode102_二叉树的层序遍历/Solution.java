package leetcode.leetcode102_¶þ²æÊ÷µÄ²ãÐò±éÀú;

import leetcode.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        if (root != null){
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (queue.size() >= 1){
            if(queue.peek() == null){
                queue.poll();
                result.add(new ArrayList<>());
                queue.add(null);
            }else{
                TreeNode p = queue.poll();
                result.get(result.size()-1).add(p.val);
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right != null){
                    queue.add(p.right);
                }
            }

        }
        return result;
    }
}
