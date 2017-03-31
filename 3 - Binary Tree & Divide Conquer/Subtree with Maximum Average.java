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
     * @return the root of the maximum average of subtree
     */
     
    class ResultType {
        public double sum, size;
        public ResultType(double sum, double size) {
            this.sum = sum;
            this.size = size;
        }
    }
    
    private TreeNode result = null;
    private double average = -Double.MAX_VALUE;
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        
        helper(root);
        
        return result;
    }
    
    public ResultType helper(TreeNode root) {
        ResultType rt = new ResultType(0.0, 0.0);
        
        if(root == null) {
            return rt;
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        rt.sum = root.val + left.sum + right.sum;
        rt.size = 1 + left.size + right.size;
        
        //double avg = (left.sum + right.sum + root.val)/(left.size + right.size + 1);
        double avg = rt.sum / rt.size;
        
        if(avg > average) {
            result = root;
            average = avg;
        }
        
        return rt;
    }
    
    
    
}