package problem449;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public String serialize(TreeNode root) {
        /**
         * 因为题目限定是BST树，所以直接通过将树转化为先序遍历string
         * 然后通过先序遍历的string重构可以唯一确定树
         */
        /**
         * 这里的先序遍历的方法更好，利用栈的后进先出的特性，将右左子节点加入
         * 到栈中，这样更加简洁
         */
        /**
         * 其实在这里我的思路是在通过先序遍历，然后在每一个node前，加一个数（表示这个node左子树中节点的数目）
         * 然后去构造树，但其实针对这一题不需要，因为这一题是BST树，只需要通过先序遍历的序列就可以还原
         */
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strs = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String str:
             strs) {
            queue.offer(Integer.parseInt(str));
        }
        return getNode(queue);
    }

    private TreeNode getNode(Queue<Integer> queue) {
        /**
         * 针对queue队列还原BST树
         */
        if(queue.isEmpty()) return null;
        Queue<Integer> smallqueue = new LinkedList<>();
        TreeNode node = new TreeNode(queue.poll());
        while (!queue.isEmpty() && queue.peek() < node.val) {
            smallqueue.offer(queue.poll());
        }
        node.left = getNode(smallqueue);
        node.right = getNode(queue);
        return node;
    }

}
