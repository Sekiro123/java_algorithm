package leetcode.leetcode104_��������������;

import leetcode.utils.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return BFS(root);
    }
    public int BFS(TreeNode p){
        if(p == null){
            return 0;
        }
        else{
            return Math.max(BFS(p.left)+1, BFS(p.right)+1);
        }
    }
}
