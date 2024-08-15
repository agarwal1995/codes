//package interviewBit.tree;
//
//import java.util.ArrayList;
//
///**
// * @author raag
// */
//public class ConstructBSTFromPreorder {
//
//    public static void main(String[] args) {
//
//    }
//
//    public TreeNode constructBST(ArrayList<Integer> A) {
//        if (A.isEmpty()) {
//            return null;
//        }
//        TreeNode head = new TreeNode(A.get(0));
//        TreeNode root = head;
//        TreeNode prevRoot = head;
//        for (int i=1;i<A.size();i++) {
//            TreeNode node = new TreeNode(A.get(i));
//            if (A.get(i)<prevRoot.val) {
//                prevRoot.left = node;
//            } else {
//                prevRoot.right = node;
//            }
//        }
//    }
//}
