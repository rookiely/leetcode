package problem113;

import java.util.ArrayList;
import java.util.List;

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
     * 自己的代码思路大致正确，就是在每次加入时候，以及完成之后需要删除当前的节点
     * 这一问题上没有考虑到，这种题型需要深刻理解，以后肯定会有借鉴
     * @param num
     * @param node
     * @param list
     * @param res
     */

    public void findPath(int num, TreeNode node, List<Integer> list, List<List<Integer>> res) {
        if(node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == num) {
            /**
             * 很重要的一点就是在这里加入res的时候
             * 需要将list重新放入一个新的Arraylist中
             * 否则会出现多条路径加入到了同一个list中
             * 然后将这同一个list加入res中
             */
            res.add(new ArrayList<>(list));
            /**
             * 同时每次到底后都需要将list中的最后一个数删除
             */
            list.remove(list.size() - 1);
            return;
        }else {
            findPath(num - node.val, node.left, list, res);
            findPath(num - node.val, node.right, list, res);
        }
        /**
         * 同时每次这个函数到了底之后，都需要将当前这个list中的最后一个数删除
         */
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPath(sum, root,list,res);
        return res;
    }

    public static void main(String[] args) {
    }
}
