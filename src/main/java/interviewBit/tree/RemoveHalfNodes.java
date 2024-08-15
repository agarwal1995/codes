package interviewBit.tree;

/**
 * @author raag
 */
public class RemoveHalfNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        new RemoveHalfNodes().solve(root);
    }

    public TreeNode solve(TreeNode A) {
        if (A==null) {
            return A;
        }
        rec(A);
        return A;
    }

    private void rec(TreeNode node) {
        if (node==null) {
            return;
        }
        if (node.left==null && node.right==null) {
            return;
        }
        if (node.left==null) {
            TreeNode temp = node.right;
            node.val = temp.val;
            node.left = temp.left;
            node.right = temp.right;
            rec(node);

        } else if (node.right == null){
            TreeNode temp = node.left;
            node.val = temp.val;
            node.left = temp.left;
            node.right = temp.right;
            rec(node);
        }
        rec(node.left);
        rec(node.right);
    }
}
