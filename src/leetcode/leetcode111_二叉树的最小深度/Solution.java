package leetcode.leetcode111_二叉树的最小深度;

import leetcode.utils.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return BFS(root);
    }
    public int BFS(TreeNode p){
        if(p == null){
            return 0;
        }
        if(p.left == null){
            return BFS(p.right)+1;
        }
        if(p.right == null){
            return BFS(p.left)+1;
        }
        return Math.min(BFS(p.left)+1, BFS(p.right)+1);
    }
}
