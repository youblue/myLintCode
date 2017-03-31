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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        
        if(root == null) {
            return result;
        }
        
        List<String>leftPaths = binaryTreePaths(root.left);
        List<String>rightPaths = binaryTreePaths(root.right);
        
        for(String path:leftPaths) {
            result.add(root.val + "->" + path);
        }
        for(String path:rightPaths) {
            result.add(root.val + "->" + path);
        }
        
        if(root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
        }
        
        return result;
    }
}