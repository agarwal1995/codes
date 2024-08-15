package interviewBit.tree;

/**
 * @author raag
 */
public class SumRootToLeafNumbers {

    long sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(5);


        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        new SumRootToLeafNumbers().sumNumbers(root);
    }

    public int sumNumbers(TreeNode a) {
//        rec(a.left, 0, (long) a.val);
        rec(a, 0, 0);
        return (int)sum;
    }

    private void rec(TreeNode node, int multiplier, long num) {
        if (node==null) {
            return;
        }
        num = (((num*10)%1003) + node.val)%1003;
        if (node.left==null && node.right==null) {
            sum = (sum + num)%1003;
            return;
        }
        rec(node.left, multiplier, num);
        rec(node.right, multiplier, num);
    }
}
