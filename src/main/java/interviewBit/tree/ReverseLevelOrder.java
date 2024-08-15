package interviewBit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class ReverseLevelOrder {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> traversed = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            traversed.add(node.val);
            pushToQueue(node.right, queue);
            pushToQueue(node.left, queue);
        }
        Collections.reverse(traversed);
        return traversed;
    }

    private void pushToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node!=null) {
            queue.add(node);
        }
    }
}
