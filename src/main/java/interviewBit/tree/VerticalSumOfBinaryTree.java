package interviewBit.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author raag
 */
public class VerticalSumOfBinaryTree {

    Map<Integer, Integer> sumMap = new TreeMap<>();

    public ArrayList<Integer> verticalSum(TreeNode A) {
        traverse(A, 0);
        return new ArrayList<>(sumMap.values());
    }

    private void traverse(TreeNode root, int x) {
        if (root==null) {
            return;
        }

        sumMap.putIfAbsent(x, 0);
        sumMap.put(x, sumMap.get(x) + root.val);
        traverse(root.left, x-1);
        traverse(root.right, x+1);
    }
}
