package problem111;

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
    public int min(int a, int b) {
        return a < b ? a : b;
    }

    public int Depth(TreeNode node) {
        if (node.left==null && node.right==null) return 1;
        else if(node.left ==null) return Depth(node.right)+1;
        else if(node.right==null) return Depth(node.left)+1;
        else return min(Depth(node.left), Depth(node.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        /**
         * 通过递归实现求最小高度
         */
        if(root == null) return 0;
        return Depth(root);
    }
}
