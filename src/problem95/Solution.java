package problem95;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.List;

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

class Solution {


    public static void main(String[] args) {

    }

    public List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        /**
         * 这里添加这么两行是为了解决输入n=0的情况，上面的两个for循环还是没有弄清楚，但是主要思想是
         * 利用递归，相当于二分法，首先随机选取根节点，然后构造左子树和右子树
         */
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(n == 0) return list;
        return genTrees(1, n);
    }
}