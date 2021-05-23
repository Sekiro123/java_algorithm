package leetcode.dfs;

public class sumOfPath1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    public boolean dfs(TreeNode node, int targetSum){
        if(node == null){
            return false;
        }
        if(node.val == targetSum && node.left == null && node.right == null){
            return true;
        }
        boolean result = dfs(node.left, targetSum-node.val) || dfs(node.right, targetSum-node.val);
        return result;
    }
}
