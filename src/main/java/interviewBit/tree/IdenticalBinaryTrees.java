package interviewBit.tree;

/**
 * @author raag
 */
public class IdenticalBinaryTrees {

    public int isSameTree(TreeNode A, TreeNode B) {
        return check(A,B)?1:0;
    }

    private boolean check(TreeNode first, TreeNode second) {
        if (first==null && second==null) {
            return true;
        }
        if (first==null || second==null) {
            return false;
        }

        if (first.val!=second.val) {
            return false;
        }
        return check(first.left, second.left) && check(first.right, second.right);
    }
}
