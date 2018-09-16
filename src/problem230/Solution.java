package problem230;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/6/3.
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
     * 以下三种方法都可以
     */
    /*private List<Integer> reslist = new ArrayList<>();
    public void iterater(TreeNode node) {
        if (node != null) {
            iterater(node.left);
            reslist.add(node.val);
            iterater(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        iterater(root);
        return reslist.get(k - 1);
    }*/
    /*public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }*/
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

}
