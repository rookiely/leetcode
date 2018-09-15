package problem235;

/**
 * Created by john on 2018/6/7.
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
 * 找二叉排序树的两个节点的最近公共父节点
 */
public class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 总共分四种情况：
         * 1、其中一个值是根节点，另一个值在左子树或者右子树
         * 2、一个值在左子树，另一个在右子树
         * 3、两个数都在左子树
         * 4、两个数都在右子树
         */
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
