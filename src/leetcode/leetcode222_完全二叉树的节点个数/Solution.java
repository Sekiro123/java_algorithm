package leetcode.leetcode222_完全二叉树的节点个数;

import leetcode.utils.TreeNode;

import java.util.LinkedList;

public class Solution {
    public int countNodes(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            result+=n;
            for (int i = 1; i<n; i++){
                TreeNode p = queue.poll();
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
