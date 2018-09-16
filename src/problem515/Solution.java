package problem515;

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

    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> results = new TreeMap<>();

    public void findMax(TreeNode node, int level) {
        if (node != null) {
            if (results.containsKey(level)) {
                if (results.get(level) < node.val) {
                    results.put(level, node.val);
                }
            } else {
                results.put(level, node.val);
            }
        }else
            return;
        findMax(node.left, level + 1);
        findMax(node.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        findMax(root,0);
        for (Iterator<Integer> it = results.keySet().iterator(); it.hasNext(); ) {
            res.add(results.get(it.next()));
        }
        return res;
    }
}
