package leetcode.leetcode94_二叉树的中序遍历;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recur(root,result);
        return result;
    }
    public void recur(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        else{
            recur(root.left, result);
            result.add(root.val);
            recur(root.right, result);

        }
    }
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null){
            stack.add(p);
            p = p.left;
        }
        while (!stack.empty()){
            p = stack.pop();
            result.add(p.val);
            if(p.right != null){
                p = p.right;
                while (p!=null){
                    stack.add(p);
                    p = p.left;
                }
            }
        }
        return result;
    }
}
