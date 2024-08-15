package interviewBit.graph;

import interviewBit.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raag
 */
public class LevelOrder {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        if (A==null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            Queue<TreeNode> queue1 = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null) {
                    queue1.add(node.left);
                }
                if (node.right!=null) {
                    queue1.add(node.right);
                }

            }

            queue = queue1;
            arrayLists.add(list);
        }
        return arrayLists;
    }
}
