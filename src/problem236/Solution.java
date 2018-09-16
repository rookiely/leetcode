package problem236;

/**
 * Created by john on 2018/6/11.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 这种递归的方法可以通过30/31个用例，但是最后一个会超时
 */
public class Solution {
    /*
        public boolean findNode(TreeNode root, TreeNode node) {
            if (root == null) return false;
            if (root.val == node.val) return true;
            return findNode(root.left, node) || findNode(root.right, node);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(findNode(root.left,p) && findNode(root.left,q)){
                return lowestCommonAncestor(root.left, p, q);
            }else if(findNode(root.right,p) && findNode(root.right,q)){
                return lowestCommonAncestor(root.right, p, q);
            }else{
                return root;
            }
        }*/

    /**
     * 这种方法省去了我的findNode函数的时间，所以不会超时
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
