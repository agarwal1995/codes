package interviewBit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class RightViewOfBinaryTree {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size>0) {
                TreeNode node = queue.poll();
                if (size==1) {
                    result.add(node.val);
                }
                size--;
                pushToQueue(node.left, queue);
                pushToQueue(node.right, queue);
            }
        }
        return result;
    }

    private void pushToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node!=null) {
            queue.add(node);
        }
    }

}
