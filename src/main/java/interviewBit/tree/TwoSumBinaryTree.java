package interviewBit.tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author raag
 */
public class TwoSumBinaryTree {

    public int t2Sum(TreeNode A, int B) {
        return t2SumTraversal(A, B, new HashSet<>());
    }

    public int t2SumTraversal(TreeNode node, int sum, Set<Integer> set) {
        if (node==null) {
            return 0;
        }
        if (set.contains(sum-node.val)) {
            return 1;
        }
        set.add(node.val);
        int x = t2SumTraversal(node.left, sum, set);
        int y = t2SumTraversal(node.right, sum, set);
        return Math.max(x, y);
    }
}
