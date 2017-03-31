public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
     
    private int m, n;
    public int numIslands(boolean[][] grid) {
        // Write your code here
        
        n = grid.length;
        if(n == 0) {
            return 0;
        }
        
        m = grid[0].length;
        if(m == 0) {
            return 0;
        }
        
        int result = 0;
        for(int i =  0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == true) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    void dfs(boolean[][]grid, int i, int j) {
        if(i < 0 || i > n-1 || j < 0 || j > m-1) {
            return;
        }
        if(grid[i][j] == true) {
            grid[i][j] = false;
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
       
    }
    
     
}