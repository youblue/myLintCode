/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    
    private int result;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        result = 0;
        
        helper(root, 0, root.val);
        
        return result;
    }
    
    public void helper(TreeNode root, int curLength, int expected) {
        if(root == null) {
            return;
        }
        
        if(root.val == expected) {
            curLength++;
        } else {
            curLength = 1;
        }
        result = Math.max(result, curLength);
        
        helper(root.left, curLength, root.val+1);
        helper(root.right, curLength, root.val+1);
        
    }
}