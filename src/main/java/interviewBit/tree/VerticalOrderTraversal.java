package interviewBit.tree;

import java.util.*;

/**
 * @author raag
 */
public class VerticalOrderTraversal {

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        if (A==null) {
            return new ArrayList<>();
        }
        levelOrderTraverse(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    private void levelOrderTraverse(TreeNode root) {
        Queue<NodePair> queue = new LinkedList<>();
        queue.add(new NodePair(root, 0));
        while (!queue.isEmpty()) {
            NodePair nodePair = queue.poll();
            TreeNode node = nodePair.node;
            map.putIfAbsent(nodePair.x, new ArrayList<>());
            map.get(nodePair.x).add(node.val);
            if (node.left!=null) {
                queue.add(new NodePair(node.left, nodePair.x-1));
            }
            if (node.right!=null) {
                queue.add(new NodePair(node.right, nodePair.x+1));
            }
        }
    }

    private void traverse(TreeNode root, int x) {
        if (root==null) {
            return;
        }
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(root.val);
        traverse(root.left, x-1);
        traverse(root.right, x+1);
    }
}

class NodePair {
    public NodePair(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }

    TreeNode node;
    int x;
}
