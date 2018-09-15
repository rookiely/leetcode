package problem513;

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

    Map<Integer, Integer> results = new TreeMap<>();
    Integer res = 0;

    public void findValue(TreeNode node, int level) {
        if (node != null) {
            if (!results.containsKey(level)) {
                results.put(level, node.val);
            }
        }else
            return;
        findValue(node.left, level + 1);
        findValue(node.right, level + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        findValue(root,0);
        for (Iterator<Integer> it = results.keySet().iterator(); it.hasNext(); ) {
            res = results.get(it.next());
        }
        return res;
    }
}
