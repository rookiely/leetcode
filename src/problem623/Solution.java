package problem623;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 这题还没做出来
 */
public class Solution {

    public void findFunc(TreeNode node, int depth, int d, int value) {
        if(node != null){
            if (depth == d - 1) {
                TreeNode addNodel = new TreeNode(value);
                TreeNode addNoder = new TreeNode(value);
                addNodel.left = node.left;
                node.left = addNodel;
                addNoder.right = node.right;
                node.right = addNoder;
            }
            findFunc(node.left, depth + 1, d, value);
            findFunc(node.right, depth + 1, d, value);
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode tem = root;
            TreeNode node = new TreeNode(v);
            node.left = tem;
            root = node;
        } else {
            findFunc(root, 1, d, v);
        }
        return root;
    }

    public void printAll(TreeNode node){
        if(node != null) {
            System.out.print(node.val);
            printAll(node.left);
            printAll(node.right);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        TreeNode resultNode = solution.addOneRow(root, 8, 2);
        solution.printAll(resultNode);
    }

}
