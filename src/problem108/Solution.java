package problem108;

/**
 * Created by john on 2018/5/29.
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
     * 这一题的思路有两个：
     * 第一：利用AVL的插入，每次插入新的节点后都重新平衡二叉树
     * 第二：利用二分法，每次找中间节点生成根节点两边的生成左右子树（通过）
     *
     * @param nums
     * @return
     */

    public TreeNode construct(int[] nums, int begin, int end) {
        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = construct(nums, begin, mid - 1);
            root.right = construct(nums, mid + 1, end);
            return root;
        } else if (begin == end) {
            return new TreeNode(nums[begin]);
        } else {
            return null;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
}
