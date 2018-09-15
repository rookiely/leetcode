package problem104;

/**
 * Created by john on 2018/5/28.
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

    public int maxDepth(TreeNode root) {
        return maxD(root, 0);
    }

    public int maxD(TreeNode node, int depth) {
        if (node != null) {
            depth++;
            int leftDepth = maxD(node.left, depth);
            int rightDepth = maxD(node.right, depth);
            return leftDepth>rightDepth?leftDepth:rightDepth;
        }else{
            return depth;
        }
    }
}
