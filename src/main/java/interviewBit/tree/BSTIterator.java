//package interviewBit.tree;
//
///**
// * @author raag
// */
//public class BSTIterator {
//
//    TreeNode root;
//    TreeNode traversalRoot;
//    int size;
//
//    public BSTIterator(TreeNode root) {
//        this.root = root;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        traversalRoot = root;
//    }
//
//    public int nextRec(TreeNode root) {
//        if (root==null) {
//            return -1;
//        }
//        int x = nextRec(root.left);
//        if (x != -1) {
//            return x;
//        }
//        int y = root.val;
//        return 0;
//    }
//
//
//}
