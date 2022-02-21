package leetcode.leetcode101_¶Ô³Æ¶þ²æÊ÷;

import leetcode.utils.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isEqual(root.left, root.right);
    }
    public boolean isEqual(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            if(left.val == right.val){
                return isEqual(left.left, right.right) && isEqual(left.right, right.left);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
