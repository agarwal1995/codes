//package interviewBit.tree;
//
//import java.util.ArrayList;
//
///**
// * @author raag
// */
//public class RecoverBinarySearchTree {
//
//    public static void main(String[] args) {
//        new RecoverBinarySearchTree().recoverTree(input1());
//    }
//
//    private static TreeNode input1() {
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.ke = new TreeNode(3);
//        root.right = new TreeNode(3);
//        root.right = new TreeNode(3);
//        return root;
//    }
//
//    ArrayList<Integer> sol = new ArrayList<>();
//
//    public ArrayList<Integer> recoverTree(TreeNode A) {
//        traversal(A);
//        return sol;
//    }
//
//    private void traversal(TreeNode root) {
//        if (root==null || !sol.isEmpty()) {
//            return;
//        }
//        if (root.left!=null && root.val<root.left.val) {
//            sol.add(root.val);
//            sol.add(root.left.val);
//            return;
//        }
//        if (root.right!=null && root.val>root.right.val) {
//            sol.add(root.val);
//            sol.add(root.right.val);
//            return;
//        }
//    }
//}
