package problem110;

/**
 * Created by john on 2018/5/30.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 虽然利用了一个标志变量flag，但是毕竟做出来了，easy。。。
     */
    private boolean flag = true;

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        else {
            int lh = height(node.left);
            int rh = height(node.right);
            if (Math.abs(lh - rh) >= 2) {
                flag = false;
            }
            return max(lh, rh) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lefth = height(root.left)+1;
        int righth = height(root.right)+1;
        if (Math.abs(lefth - righth) >= 2) {
            flag = false;
        }
        return flag;
    }
}
