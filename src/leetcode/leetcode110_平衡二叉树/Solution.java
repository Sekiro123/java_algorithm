package leetcode.leetcode110_平衡二叉树;

import leetcode.utils.TreeNode;

public class Solution {
    // 计算子树深度，如果返回-1代表不平衡
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public int height(TreeNode p){
        if(p == null){
            return 0;
        }
        int leftHeight = height(p.left);
        int rightHeight = height(p.right);
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)<=1){
            return Math.max(leftHeight, rightHeight)+1;
        }else {
            return -1;
        }
    }
}
