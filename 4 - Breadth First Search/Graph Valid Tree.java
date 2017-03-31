public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(n == 0 || edges == null || edges.length != n-1) {
            return false;
        }
        
        Map<Integer, Set<Integer> >graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Set<Integer>hash = new HashSet<>();
        Queue<Integer>queue = new LinkedList<>();
        
        hash.add(0);
        queue.offer(0);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(Integer neighbor:graph.get(node)) {
                if(!hash.contains(neighbor)) {
                    hash.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        if(hash.size() != n) {
            return false;
        }
        
        
        return true;
    }
}