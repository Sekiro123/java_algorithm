package leetcode.leetcode257_������������·��;

import leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        backTrace(root, "", result);
        return result;
    }
    public void backTrace(TreeNode p, String temp, List<String> result){
        if(p == null){
            return;
        }
        else if(p.left == null &&p.right == null){
            if(!"".equals(temp)){
                temp = new StringBuffer().append(temp).append("->").append(p.val).toString();
            }else{
                temp = new StringBuffer().append(p.val).toString();
            }
            result.add(temp);
            return;
        }
        else{
            if(!"".equals(temp)){
                temp = new StringBuffer().append(temp).append("->").append(p.val).toString();
            }else{
                temp = new StringBuffer().append(p.val).toString();
            }
            backTrace(p.left, temp, result);
            backTrace(p.right, temp, result);
        }
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        binaryTreePaths(root);
    }

}
