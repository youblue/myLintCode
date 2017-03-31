/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null) {
            return node;
        }
        // BFS to get node set
        ArrayList<UndirectedGraphNode>nodes = getNodes(node);
        // Hashmap to map oldNode to new
        HashMap<UndirectedGraphNode, UndirectedGraphNode>map = new HashMap<>();
        for(UndirectedGraphNode oldNode:nodes) {
            map.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }
        // Copy edges
        for(UndirectedGraphNode oldNode:nodes) {
            UndirectedGraphNode newNode = map.get(oldNode);
            for(UndirectedGraphNode neighbor:oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
    
    private ArrayList<UndirectedGraphNode>getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode>set = new HashSet<UndirectedGraphNode>();
        
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode n:head.neighbors) {
                if(!set.contains(n)) {
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
}