package problem337;

import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;

/**
 * Created by john on 2018/6/12.
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
     * 第一种：直接利用recursive来找，主要找到最优子结构，optimal substructure
     * rob（root）代表找到以root为根的子树的可以抢的最大的金钱
     * 所以其实也就是两种情况：
     * 1、抢root，然后抢rob(root.left.left)+rob(root.left.right)+rob(root.right.left)+rob(root.right)
     * 2、不抢root，然后抢rob(root.left)+rob(root.right)
     * @param root
     * @return
     * 但这种方法会有一个用例通不过，超时
     */
    /*
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + val, rob(root.left) + rob(root.right));
    }*/

    /**
     * 在递归的过程中会出现重复计算的情况，也就导致时间复杂度很大，
     * 所以利用DP，利用一个hashmap去存储之前计算过的子树的最大抢到的金额
     * @param root
     * @return
     */
    /*
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robsub(root,map);
    }

    public int robsub(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += robsub(root.left.left,map) + robsub(root.left.right,map);
        }
        if (root.right != null) {
            val += robsub(root.right.left,map) + robsub(root.right.right,map);
        }
        val = Math.max(root.val + val, robsub(root.left,map) + robsub(root.right,map));
        map.put(root, val);
        return val;
    }*/

    /**
     * 为什么会在recursive的情况下出现重复计算的问题呢？
     * 因为我们一开始对于rob函数的定义有问题，我们定义rob并没有包含
     * 是否抢root的情况，所以每次调用rob函数的时候会出现重复计算着两种情况
     * 所以在这里我们重新定义rob函数，robsub函数，让他返回的是一个数组
     * 数组的第一个代表不抢root抢到的最大的金额，第二个值代表抢root抢到的最大的金额
     * 从而问题也就转化为一个贪心算法，
     */
    public int rob(TreeNode root) {
        int[] res = robsub(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robsub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robsub(root.left);
        int[] right = robsub(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
