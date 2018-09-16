package problem222;

/**
 * Created by john on 2018/5/31.
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
     * 没有好的思路，就参考了柳婼的代码了
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getLeft(root);
        int r = getRight(root);
        if (l == r) {
            return (2 << (l - 1)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getLeft(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public int getRight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        return h;
    }
}
