
  Definition of TreeNode
  public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
public class Solution {
    
      @param root the root of binary tree
      @return the root of the minimum subtree
     
     
    private int subtreeSum = Integer.MAX_VALUE;
    private TreeNode subtree = null;
    
    public TreeNode findSubtree(TreeNode root) {
         Write your code here
        helper(root);
        return subtree;
    }
    
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = root.val + helper(root.left) + helper(root.right);
        if(sum  subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}