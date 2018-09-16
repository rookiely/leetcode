package problem116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by john on 2018/5/29.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
    }

    public void connect(TreeLinkNode root) {
        /**
         * 所谓的perfect binary tree就是满二叉树
         */
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            TreeLinkNode curnode = queue.poll();
            if (curnode.left != null) {
                queue.offer(curnode.left);
            }
            if (curnode.right != null) {
                queue.offer(curnode.right);
            }
            count--;
            while (count-- != 0) {
                TreeLinkNode nextnode = queue.poll();
                if (nextnode.left != null) {
                    queue.offer(nextnode.left);
                }
                if (nextnode.right != null) {
                    queue.offer(nextnode.right);
                }
                curnode.next = nextnode;
                curnode = nextnode;
            }
            curnode.next = null;
        }
    }
}
