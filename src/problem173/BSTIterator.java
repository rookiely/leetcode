package problem173;

import java.util.Stack;

/**
 * Created by john on 2018/5/30.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {
    /**
     * 这题中的next函数是用来求树中下一个最小的值
     * 所以其实就是中序遍历
     * 思路有两个：
     * 1、利用栈实现中序遍历（可以保证空间复杂度是O（h），hasnext的时间复杂度是O（1），但是next的时间复杂度是多少呢？
     * O（h）还是O（1）？
     * 2、将树改成链表，从而可以保证hasnext和next的时间复杂度都是O（1），但是空间复杂度就是O（n）了
     * 两种方法都没有完全达到题目的标准
     * 首先我对题目的next没有正确理解，所以导致没有思路，以上两个思路都是discuss中的
     */

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempnode = stack.pop();
        pushAll(tempnode.right);
        return tempnode.val;
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
