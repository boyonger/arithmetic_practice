package leetcode.binarytree;

/*
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaxRoadSum {

    public int max;

    public int maxPathSum(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    public int dfs(TreeNode node, int sum) {
        int left = 0, right = 0;
        if (node.left != null) {
            left = dfs(node.left, sum);
        }
        if (node.right != null) {
            right = dfs(node.right, sum);
        }
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        sum = left + right + node.val;
        int maxWithout = 0;
        if (node.val < 0) {
            // 找出最大的max
            maxWithout = Math.max(left + right + node.val, Math.max(left, right));
        }
        max = Math.max(Math.max(maxWithout, sum), max);
        return sum;
    }
}
