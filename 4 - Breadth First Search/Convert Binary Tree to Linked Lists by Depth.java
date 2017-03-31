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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode>result = new ArrayList<ListNode>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode head = queue.poll();
            ListNode level = new ListNode(head.val);
            if(head.left != null) {
                queue.offer(head.left);
            }
            if(head.right != null) {
                queue.offer(head.right);
            }
            
            ListNode curLevel = level;
            for(int i = 1; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.next = new ListNode(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                curLevel = curLevel.next;
            }
            result.add(level);
        }
        return result;
    }
}