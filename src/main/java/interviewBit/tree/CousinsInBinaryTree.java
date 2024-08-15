package interviewBit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(10);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        new CousinsInBinaryTree().solve(root, 5);
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> sol = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        int h = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelChilds = new ArrayList<>();
            int foundB = -1;
            int i = 0;
            while (size>0) {
                TreeNode node = queue.poll();
                size--;
                if (node.val==B) {
                    foundB = i;
                }
                i++;
                levelChilds.add(node.val);
                pushToQueue(node.left, queue);
                pushToQueue(node.right, queue);
            }
            if (foundB!=-1) {
                for (int j=0;j<levelChilds.size();j++) {
                    if (j==foundB || ((foundB%2==0 && j==foundB+1) || (foundB%2!=0 && j==foundB-1)) || levelChilds.get(j)==-1) {
                        // doNothing
                        continue;
                    }
                    sol.add(levelChilds.get(j));
                }
                break;
            }
        }
        return sol;

    }

    private void pushToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node!=null) {
            queue.add(node);
        } else  {
            queue.add(new TreeNode(-1));
        }
    }
}
