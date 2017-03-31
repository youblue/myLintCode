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
     * @return: An integer.
     */
    
    private int result;
    public int maxDepth(TreeNode root) {
        // write your code here
        result = 0;
        
        helper(root, 1);
        
        return result;
    }
    
    public void helper(TreeNode node, int depth) {
        if(node == null) {
            return;
        }
        
        if(depth > result) {
            result = depth;
        }
        
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
        
    }
    
}