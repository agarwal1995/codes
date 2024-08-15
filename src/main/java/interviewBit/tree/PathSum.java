package interviewBit.tree;

/**
 * @author raag
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        new PathSum().hasPathSum(root, 1);
    }

    public int hasPathSum(TreeNode A, int B) {
        return hasSum(A, B, 0)?1:0;
    }

    private boolean hasSum(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            return false;
        }
        currentSum = currentSum + root.val;
        if (currentSum==sum) {
            if (root.left==null && root.right==null) {
                return true;
            }
        }

        boolean leftVal = hasSum(root.left, sum, currentSum);
        if (leftVal) {
            return true;
        }
        boolean rightVal = hasSum(root.right, sum, currentSum);
        if (rightVal) {
            return true;
        }
        return false;
    }
}


