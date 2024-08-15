package interviewBit.tree;

import java.util.ArrayList;

/**
 * @author raag
 */
public class RootToLeafPathsWithSum {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        new RootToLeafPathsWithSum().pathSum(node, 22);
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        rec(A, new ArrayList<>(), 0, B);
        return res;
    }

    private void rec(TreeNode node, ArrayList<Integer> list,int currentSum, int sumToBe) {
        if (node==null) {
            return;
        }
        currentSum = currentSum + node.val;
        list.add(node.val);
        if (node.left==null && node.right==null && currentSum==sumToBe) {
            res.add(new ArrayList<>(list));
        }
        rec(node.left, list,currentSum, sumToBe);
        rec(node.right, list,currentSum, sumToBe);

        list.remove(list.size()-1);
    }
}
