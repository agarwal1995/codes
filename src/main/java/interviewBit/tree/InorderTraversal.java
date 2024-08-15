package interviewBit.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author raag
 */
public class InorderTraversal {

    Stack<TreeNode> nodeStack = new Stack<>();

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> sol = new ArrayList<>();
        pushLeft(A);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            sol.add(node.val);
            pushLeft(node.right);
        }
        return sol;
    }

    private void pushLeft(TreeNode node) {
        while (node!=null) {
            nodeStack.push(node);
            node = node.left;
        }
    }
}
