package interviewBit.tree;



public class KthSmallestInTree {

    int count=0;

    public static void main(String[] args) {

        System.out.println(new KthSmallestInTree().inorder(input1(), 2));
        System.out.println(new KthSmallestInTree().inorder(input1(), 1));
        System.out.println(new KthSmallestInTree().inorder(input1(), 3));
    }

    private static TreeNode input1() {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        return treeNode;
    }

    public int kthsmallest(TreeNode A, int B) {
        return inorder(A, B);
    }

    private int inorder(TreeNode node, int B) {
        if (node==null) {
            return Integer.MAX_VALUE;
        }
        int left = inorder(node.left, B);
        if (left!=Integer.MAX_VALUE) {
            return left;
        }
        count++;
        if (count == B) {
            return node.val;
        }
        return inorder(node.right, B);
    }
}
