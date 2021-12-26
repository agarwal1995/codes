package leetcode.studyplan.datastructure.first;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        util(root, sol);
        return sol;
    }

    public void util(TreeNode root, List<Integer> sol) {
        if(root==null){
            return;
        }
        sol.add(root.val);
        util(root.left, sol);
        util(root.right, sol);
    }
}
