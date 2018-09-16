package problem103;

import java.util.*;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**思路一：
         * 这里我们可以考虑在进行层次遍历的基础上添加一个栈
         * 在遇到树的层数在奇数的时候，将数据从队列中转到结果list中，
         * 中间需要通过栈将顺序转换一下(其实和后面一种方法思路一样，只不过
         * 自己用栈实现了list的反转
         */
        /**思路二：
         * 可以在将奇数层的树的节点放到list中后，将list集合顺序反转即可
         */
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- != 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
            if (level % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
