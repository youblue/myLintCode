/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
     
    class ResultType {
        public int leftHeight;
        public int rightHeight;
        boolean isBalanced;
        public ResultType(int leftHeight, int rightHeight, boolean isBalanced) {
            this.leftHeight = leftHeight;
            this.rightHeight = rightHeight;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType result = new ResultType(0, 0, false);
        
        result = helper(root);
        
        if(result.isBalanced) {
            return true;
        }
        
        return false;
    }
    
    public ResultType helper(TreeNode root) {
        ResultType result = new ResultType(0, 0, false); 
        if(root == null) {
            result.isBalanced = true;
            return result;
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        result.leftHeight = Math.max(left.leftHeight, left.rightHeight) + 1;
        result.rightHeight = Math.max(right.leftHeight, right.rightHeight) + 1;
        
        
        if(left.isBalanced == true
           && right.isBalanced == true
           && Math.abs(result.leftHeight - result.rightHeight) < 2) {
            result.isBalanced = true;
        }
        
        
        return result;
        
    }
    
    
}