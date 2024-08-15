package interviewBit.tree;

/**
 * @author raag
 */
public class ConsecutiveParentChild {

    public int consecutiveNodes(TreeNode A) {
        return rec(A);
    }


    private int rec(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int consecutiveThis = 0;
        if (A.left!=null && Math.abs(A.val-A.left.val)==1) {
            consecutiveThis++;
        }
        if (A.right!=null && Math.abs(A.val-A.right.val)==1) {
            consecutiveThis++;
        }
        return consecutiveThis + rec(A.left) + rec(A.right);

    }
}
