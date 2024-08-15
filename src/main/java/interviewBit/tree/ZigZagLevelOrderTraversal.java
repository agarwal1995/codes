package interviewBit.tree;

import java.util.*;

/**
 * @author raag
 */
public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        new ZigZagLevelOrderTraversal().zigzagLevelOrder(root);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean left = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>();
            Deque<TreeNode> queue1 = new ArrayDeque<>();
            while (size>0) {
                TreeNode node = queue.poll();
                assert node != null;
                row.add(node.val);
                if (left) {
                    pushToStack(node.left, queue1);
                    pushToStack(node.right, queue1);
                } else {
                    pushToStack(node.right, queue1);
                    pushToStack(node.left, queue1);
                }
                size--;
            }
            Iterator<TreeNode> it = queue1.descendingIterator();
            while(it.hasNext()) {
                queue.add(it.next());
            }
            result.add(row);
            left = !left;
        }
        return  result;
    }

    private void pushToStack(TreeNode node, Queue<TreeNode> stack) {
        if (node!=null) {
            stack.add(node);
        }
    }
}
