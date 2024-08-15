package interviewBit.tree;

import java.util.ArrayList;

/**
 * @author raag
 */
public class PathToGivenNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        new PathToGivenNode().solve(root, 5);
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> sol = new ArrayList<>();
        recursion(A, B, sol);
        return sol;
    }

    private boolean recursion(TreeNode root, int b, ArrayList<Integer> list) {
        if (root==null) {
            return false;
        }
        list.add(root.val);
        if (root.val == b) {
            return true;
        }
        boolean foundLeft = recursion(root.left, b, list);
        if (foundLeft) {
            return true;
        }
        boolean foundRight = recursion(root.right, b, list);
        if (foundRight) {
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}
