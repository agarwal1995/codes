package leetcode.tree;

public class SumRootToLeafNode {


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }



    public int sumNumbers(TreeNode root) {
        return sumUtil(root, 0);
    }

    public int sumUtil(TreeNode root, int sumTillNow) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return root.val + 10*sumTillNow;
        }
        int left  = sumUtil(root.left,  root.val + 10* sumTillNow);
        int right = sumUtil(root.right,  root.val +  10 * sumTillNow);
        return left + right;
    }
}

/**
 * root = 4, h=0, sum = 0
 * root = 9, h=1, sum = 4
 * root = 5, h=2, sum = 49
 *
 */
