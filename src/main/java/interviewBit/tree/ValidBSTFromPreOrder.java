package interviewBit.tree;

import java.util.*;

/**
 * @author raag
 */
public class ValidBSTFromPreOrder {

    public static void main(String[] args) {
        new ValidBSTFromPreOrder().solve(new ArrayList<>(Arrays.asList(5,3,1,2,8,7)));
    }

    private Node rootTreeNode = null;

    public int solve(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>(A);
        if (set.size()!=A.size()) {
            return 0;
        }
        for (int x:A) {
            createTree(rootTreeNode, new Node(x));
        }

        List<Integer> preOrderT = new ArrayList<>();
        preOrderTraversal(rootTreeNode, preOrderT);

        for (int i=0;i<A.size();i++) {
            if (A.get(i).compareTo(preOrderT.get(i))!=0) {
                return 0;
            }
        }

        return 1;
    }

    private void preOrderTraversal(Node node, List<Integer> preorder) {
        if (node==null) {
            return;
        }
        preorder.add(node.val);
        preOrderTraversal(node.left, preorder);
        preOrderTraversal(node.right, preorder);
    }

    private void createTree(Node root, Node node) {
        if (rootTreeNode==null) {
            rootTreeNode = node;
            return;
        }
        if (root.val < node.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                createTree(root.right, node);
            }
        } else {
            if (root.left == null) {
                root.left = node;
            } else {
                createTree(root.left, node);
            }
        }
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
