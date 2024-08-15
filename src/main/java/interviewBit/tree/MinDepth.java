package interviewBit.tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author raag
 */
public class MinDepth {

    public int minDepth(TreeNode A) {
        TreeSet<Integer> set = new TreeSet<>();
        depth(A, set, 0 );
        return set.first();
    }

    private void depth(TreeNode node, Set<Integer> set, int x) {
        if (node==null) {
            return;
        }
        if (node.right == null && node.left == null) {
            set.add(x+1);
        }
        depth(node.left, set, x+1);
        depth(node.right, set, x+1);
    }
}
