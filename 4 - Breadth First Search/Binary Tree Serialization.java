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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) {
            return "{}";
        }
        StringBuilder result = new StringBuilder();
        result.append("{");
        Queue<TreeNode>queue = new LinkedList<>();
        Queue<String>strqueue = new LinkedList<>();
        queue.offer(root);
        strqueue.offer(Integer.toString(root.val));
        
        while(!strqueue.isEmpty()) {
            StringBuilder level = new StringBuilder();
            level.append("");
            int size = strqueue.size();
            for(int i = 0; i < size; i++) {
                String nodeStr = strqueue.poll();
                level.append(nodeStr);
                if(!nodeStr.equals(",#")) {
                    TreeNode node = queue.poll();
                    if(node.left == null) {
                        strqueue.offer(",#");
                    } else {
                        queue.offer(node.left);
                        strqueue.offer(","+Integer.toString(node.left.val));
                    }
                    
                    if(node.right == null) {
                        strqueue.offer(",#");
                    } else {
                        queue.offer(node.right);
                        strqueue.offer(","+Integer.toString(node.right.val));
                    }
                }
            }
            result.append(level);
        }
        /*
        while(dataTrim.endsWith("#")) {
            dataTrim = dataTrim.substring(0, dataTrim.length()-1);
        }
        */
        result.append("}");
        
        //System.out.println(result.toString());
        
        return result.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
     
    public TreeNode deserialize(String data) {
        // write your code here
        
        String dataTrim = data.substring(1, data.length()-1);
        TreeNode empty = null;
        if(dataTrim == null || dataTrim.length() == 0) {
            return empty;
        }
        

        while(dataTrim.endsWith(",#")) {
            dataTrim = dataTrim.substring(0, dataTrim.length()-2);
        }
        //System.out.println(dataTrim);
        
        //System.out.println(dataTrim);
        String[] dataArray = dataTrim.split(",");
        
        /*
        dataTrim = dataTrim.replace(",", "");
        String[] dataArray = new String[dataTrim.length()];
        for(int i = 0; i < dataTrim.length(); i++) {
            dataArray[i] = Character.toString(dataTrim.charAt(i));
        }
        */
        
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        int levelNum = 1;
        int start = 1;
    
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        
        while(start < dataArray.length) {
            levelNum *= 2;
            int size = levelNum;
            for(int i = start; i < Math.min(start+size, dataArray.length); i=i+2) {
                TreeNode head = queue.poll();
                
                if(!dataArray[i].equals("#")) {
                    head.left = new TreeNode(Integer.parseInt(dataArray[i]));
                    queue.offer(head.left);
                } else {
                    levelNum--;
                }
                
                if(i+1 < dataArray.length) {
                    if(!dataArray[i+1].equals("#")) {
                        head.right = new TreeNode(Integer.parseInt(dataArray[i+1]));
                        queue.offer(head.right);
                    } else {
                        levelNum--;
                    }
                }
                
            }
            start += size;
        }
        
    
        return root;
        
        
    }
    
    
}
