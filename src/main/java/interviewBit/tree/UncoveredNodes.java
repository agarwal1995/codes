package interviewBit.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class UncoveredNodes {

    public Long coveredNodes(TreeNode A) {
        return traverse(A);
    }

    private Long traverse(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        long sumCovered = 0;
        long sumUnCovered = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            int x = s;
            while (s>0) {
                TreeNode node = queue.poll();
                if (s==1 || s==x) {
                    sumUnCovered += node.val;
                } else {
                    sumCovered += node.val;
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                s--;
            }
        }
        return Math.abs(sumCovered - sumUnCovered);
    }
}
