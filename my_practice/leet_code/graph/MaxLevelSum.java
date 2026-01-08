package my_practice.leet_code.graph;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                sumAtCurrentLevel += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel;
                ans = level;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxLevelSum solution = new MaxLevelSum();
        TreeNode root = new TreeNode(1,
                new TreeNode(7,
                        new TreeNode(7),
                        new TreeNode(-8)),
                new TreeNode(0));
        int result = solution.maxLevelSum(root);
        System.out.println("The level with the maximum sum is: " + result);
    }

}
