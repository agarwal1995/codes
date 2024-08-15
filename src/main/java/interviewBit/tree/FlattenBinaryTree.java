package interviewBit.tree;

import javax.management.StringValueExp;

/**
 * @author raag
 */
public class FlattenBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        new FlattenBinaryTree().flatten(root);
    }

    public TreeNode flatten(TreeNode a) {
        rec(a);
        return a;
    }

    private TreeNode rec(TreeNode node) {
        if (node==null) {
            return null;
        }
//        if (node.left==null) {
//            node.right = rec(node.right);
//        }
        TreeNode tmp = node.right;
        boolean leftNull = node.left==null;
        node.right = node.left;
        node.left = null;
        rec(node.right);
        while (node.right!=null) {
            node = node.right;
        }
        node.right = tmp;
        rec(node.right);
        return node;
    }
}
