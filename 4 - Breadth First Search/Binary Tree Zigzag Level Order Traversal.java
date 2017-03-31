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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer> >result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int isReverseNeed = 0;
        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null) {
                    queue.add(head.left);
                }
                if(head.right != null) {
                    queue.add(head.right);
                }
            }
            if(isReverseNeed == 1) {
                Collections.reverse(level);
                isReverseNeed = 0;
            } else {
                isReverseNeed = 1;
            }
            result.add(level);
        }
        return result;
    }
}