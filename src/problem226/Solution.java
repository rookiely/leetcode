package problem226;

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


    public TreeNode invertTree(TreeNode root) {
        /**
         * 方法一：
         */
        /*
        if(root == null) return null;
        else {
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            TreeNode tnode = root.left;
            root.left = root.right;
            root.right = tnode;
            return root;
        }*/
        /**方法二：
         * 用这种方法必须先保存root.left,root.right
         * 否则在第一步将root.left调用完了之后,root.left的子树已经改变了，
         * 已经不是原来的root.left子树了，所以我们需要先保存root.left，
         * 就算第一步改变了root.left，但是我们是将left放入下一步的，所以
         * 放入的left是没有改变的root的左子树
         */
        /*if (root == null) {
            return null;
        }
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;*/
        /**
         * 方法三：用栈
         */

        return null;
    }
}
