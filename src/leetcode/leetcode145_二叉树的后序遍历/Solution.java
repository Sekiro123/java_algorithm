package leetcode.leetcode145_二叉树的后序遍历;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode p = stack.pop();
            result.add(p.val);
            if(p.left != null){
                stack.add(p.left);
            }
            if(p.right != null){
                stack.add(p.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
