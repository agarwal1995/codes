package leetcode.studyplan.datastructure.first;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        util(root, sol);
        return sol;
    }

    public void util(TreeNode root, List<Integer> sol) {
        if(root==null){
            return;
        }
        util(root.left, sol);
        sol.add(root.val);
        util(root.right, sol);
    }
}
