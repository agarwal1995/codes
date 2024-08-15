package interviewBit.tree;

/**
 * @author raag
 */
public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode A) {
        return rec(A);
    }

    private int rec(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return 1 + Math.max(rec(root.left), rec(root.right));
    }
}
