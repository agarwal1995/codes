package interviewBit.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raag
 */
public class DiagonalTraversal {

    public static void main(String[] args) {

    }

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

    public ArrayList<Integer> solve(TreeNode root) {
        traverse(root, 0);
        ArrayList<Integer> sol = new ArrayList<>();
        for (ArrayList<Integer> val : map.values()) {
            sol.addAll(val);
        }
        return sol;
    }

    private void traverse(TreeNode root, int x) {
        if (root==null) {
            return;
        }

        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(root.val);
        traverse(root.left, x+1);
        traverse(root.right, x);
    }
}
