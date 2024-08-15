package interviewBit.tree;

import java.util.*;

/**
 * @author raag
 */
public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        new LeastCommonAncestor().lca(root, 6, 7);
    }

    public int lca(TreeNode A, int B, int C) {
        List<Integer> firstNumberPath = new ArrayList<>();
        List<Integer> secondNumberPath = new ArrayList<>();

        if (!recPath(A, firstNumberPath, B)) {
            return -1;
        }

        if (!recPath(A, secondNumberPath, C)) {
            return -1;
        }

        // or look for the first mismatch
        Collections.reverse(firstNumberPath);
        Collections.reverse(secondNumberPath);
        Set<Integer> map = new LinkedHashSet<>(firstNumberPath);
        for (int x:secondNumberPath) {
            if (map.contains(x)) {
                return x;
            }
        }
        return -1;
    }

    private boolean recPath(TreeNode node, List<Integer> nodes, int b) {
        if (node==null) {
            return false;
        }
        nodes.add(node.val);
        if (node.val == b) {
            return true;
        }
        if (recPath(node.left, nodes, b)) {
            return true;
        }
        if (recPath(node.right, nodes, b)) {
            return true;
        }
        nodes.remove(nodes.size()-1);
        return false;
    }
}
