package interviewBit.tree;

/**
 * @author raag
 */
public class MergeTwoBinaryTree {

    private TreeNode solve(TreeNode a, TreeNode b) {
        if(a==null) {
            return b;
        }
        if (b==null) {
            return a;
        }
        TreeNode node = new TreeNode(a.val + b.val);
        node.left = solve(a.left, b.left);
        node.right = solve(a.right, b.right);
        return node;
    }
}
