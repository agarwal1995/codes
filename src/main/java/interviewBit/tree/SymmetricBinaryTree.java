package interviewBit.tree;

/**
 * @author raag
 */
public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        return check(A.left, A.right)?1:0;
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
            return true;
        }
        if (left==null || right==null) {
            return false;
        }
        if (left.val!=right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
