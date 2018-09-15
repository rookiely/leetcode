package problem101;

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

    public static void main(String[] args){}

    /*public boolean isSymmetric(TreeNode root) {
        *//**
         * 这里需要考虑到root为空的情况，否则测试用例：“[]”会报空指针异常
         *//*
        if(root == null) return true;
        return check(root.left,root.right);
    }

    public boolean check(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }else if(left == null || right == null){
            return false;
        }
        if (left.val == right.val) {
            return check(left.left, right.right)&&check(left.right, right.left);
        }else{
            return false;
        }
    }*/

    /**
     * 非递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> snode = new Stack<>();
        if (root == null) {
            return true;
        }
        snode.push(root.left);
        snode.push(root.right);
        while (!snode.isEmpty()) {
            TreeNode p1 = snode.pop();
            TreeNode p2 = snode.pop();
            if (p1 == null && p2 == null) {
                continue;
            } else if (p1 == null || p2 == null || p1.val != p2.val) {
                return false;
            }
            snode.push(p1.left);
            snode.push(p2.right);
            snode.push(p1.right);
            snode.push(p2.left);
        }
        return true;
    }

}