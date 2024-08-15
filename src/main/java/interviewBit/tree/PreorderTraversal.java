package interviewBit.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author raag
 */
public class PreorderTraversal {

    Stack<TreeNode> stack = new Stack<>();

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A==null) {
            return result;
        }
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            pushToStack(node.right);
            pushToStack(node.left);
        }
        return result;
    }

    private void pushToStack(TreeNode node) {
        if (node!=null) {
            stack.push(node);
        }
    }
}
