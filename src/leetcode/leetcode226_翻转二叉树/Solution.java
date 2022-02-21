package leetcode.leetcode226_·­×ª¶þ²æÊ÷;

import leetcode.utils.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        BFS(root);
        return root;
    }
    public void BFS(TreeNode p){
        if(p == null || (p.left == null && p.right == null)){
            return;
        }else{
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
            BFS(p.left);
            BFS(p.right);
        }
    }
}
