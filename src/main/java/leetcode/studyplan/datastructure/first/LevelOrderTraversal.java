package leetcode.studyplan.datastructure.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if(root==null) {
            return sol;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) {
                    nextQ.add(node.left);
                }
                if(node.right!=null) {
                    nextQ.add(node.right);
                }
            }
            q = nextQ;
            sol.add(list);
        }
        return sol;
    }
}
