package problem199;

import java.util.ArrayList;
import java.util.List;

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

public class Solution {

    public void rightview(TreeNode node, List<Integer> list, int height) {
        if(node == null) return;
        if (height == list.size()) {
            list.add(node.val);
        }
        rightview(node.right, list, height + 1);
        rightview(node.left, list, height + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        /**
         * 我没有想到好的思路，就是直接利用层次遍历的思想，将每一层的最后一个节点输出
         * 参考discuss中的思路：递归的时候从右向左
         */
        List<Integer> res = new ArrayList<>();
        rightview(root,res,0);
        return res;
    }
}
