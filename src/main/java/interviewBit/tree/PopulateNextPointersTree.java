package interviewBit.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class PopulateNextPointersTree {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            while (size>0) {
                TreeLinkNode node = queue.poll();
                size--;
                pushToQueue(node.left, queue);
                pushToQueue(node.right, queue);
                if (size!=0) {
                    TreeLinkNode temp = queue.peek();
                    node.next = temp;
                }

            }
        }
    }

    private void pushToQueue(TreeLinkNode node, Queue<TreeLinkNode> queue) {
        if (node!=null) {
            queue.add(node);
        }
    }



}
