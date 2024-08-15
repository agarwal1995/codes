package interviewBit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author raag
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        new PostOrderTraversal().postorderTraversal(root);
    }


    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> sol = new ArrayList<>();
        if (A==null) {
            return sol;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sol.add(node.val);
            pushNode(stack, node.left);
            pushNode(stack, node.right);
        }
        Collections.reverse(sol);
        return sol;
    }

    private void pushNode(Stack<TreeNode> stack, TreeNode node) {
        if (node!=null) {
            stack.push(node);
        }
    }




}
