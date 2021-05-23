package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class sumOfPath2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, result, temp);
        return result;
    }
    public void dfs(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> temp){
        if(node == null){
            return;
        }
        if(node.val == targetSum && node.left == null && node.right == null){
            temp.add(node.val);
            result.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(node.val);
        dfs(node.left, targetSum-node.val, result, temp);
        dfs(node.right, targetSum-node.val, result, temp);
        temp.remove(temp.size()-1);
        return;
    }
}
