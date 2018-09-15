package problem94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by john on 2018/5/27.
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

    public static void main(String[] args) {}


    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 初始化的时候需要用new去初始化，不能用null，否则会空指针异常
         */
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> snode = new Stack<>();
        TreeNode p = root;
        TreeNode q = null;
        while (!snode.isEmpty() || p != null) {
            if (p != null) {
                snode.push(p);
                p = p.left;
            } else {
                q = snode.pop();
                res.add(q.val);
                p = q.right;
            }
        }
        return res;
    }
}
