package leetcode.leetcode110_ƽ�������;

import leetcode.utils.TreeNode;

public class Solution {
    // ����������ȣ��������-1����ƽ��
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
