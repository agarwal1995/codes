package interviewBit.tree;

/**
 * @author raag
 */
public class BalancedBinaryTree {

    public int isBalanced(TreeNode A) {
        int H = balancedBinaryTree(A);
        if (H==-1) {
            return 0;
        }
        return 1;
    }

    private int balancedBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int lH = balancedBinaryTree(root.left);
        if (lH==-1) {
            return -1;
        }
        int rH = balancedBinaryTree(root.right);
        if (rH==-1) {
            return -1;
        }
        if (Math.abs(lH-rH)>1) {
            return -1;
        }
        return 1+ Math.max(lH, rH);
    }
}
