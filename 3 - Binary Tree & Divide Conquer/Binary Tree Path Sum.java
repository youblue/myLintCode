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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer> >result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        ArrayList<Integer>path = new ArrayList<Integer>();
        path.add(root.val);
        
        helper(root, target, path, root.val, result);
        
        return result;
    }
    
    public void helper(TreeNode root, int target, ArrayList<Integer>path, int sum, List<List<Integer> >result) {
        if(root.left == null && root.right == null) {
            if(sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if(root.left != null) {
            path.add(root.left.val);
            helper(root.left, target, path, sum + root.left.val, result);
            path.remove(path.size()-1);
        }
        if(root.right != null) {
            path.add(root.right.val);
            helper(root.right, target, path, sum + root.right.val, result);
            path.remove(path.size()-1);
        }
    }
    
}