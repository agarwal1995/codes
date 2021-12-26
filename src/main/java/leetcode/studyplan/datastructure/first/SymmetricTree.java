package leetcode.studyplan.datastructure.first;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);

    }
    public boolean isSymmetric(TreeNode first, TreeNode second) {
        if(first==null && second!=null) {
            return false;
        }
        if(first!=null && second==null) {
            return false;
        }
        if(first==null) {
            return true;
        }
        if(first.val!=second.val) {
            return false;
        }
        return isSymmetric(first.left, second.right) && isSymmetric(first.right, second.left);

    }
}
