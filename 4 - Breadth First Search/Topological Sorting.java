/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode>result = new ArrayList<DirectedGraphNode>();
        if(graph == null) {
            return result;
        }
        
        // 1. get indegree of each nodes
        HashMap<DirectedGraphNode, Integer>map = new HashMap<>();
        for(DirectedGraphNode node:graph) {
            for(DirectedGraphNode neighbor:node.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                } else {
                    map.put(neighbor, map.get(neighbor)+1);
                }
            }
        }
        
        // 2. Find the head node
        Queue<DirectedGraphNode>queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node:graph) {
            if(!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }
        
        // 3. BFS the graph, when a node is polled, indgree decreases by 1
        while(!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            for(DirectedGraphNode n:head.neighbors) {
                map.put(n, map.get(n)-1);
                if(map.get(n) == 0) {
                    result.add(n);
                    queue.offer(n);
                }
            }
        }
        return result;
        
    }
}