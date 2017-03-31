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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        
        while(node != null || !st.empty()) {
            while(node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            result.add(node.val);
            
            node = node.right;
            
        }
        
        return result;
        
    }
}