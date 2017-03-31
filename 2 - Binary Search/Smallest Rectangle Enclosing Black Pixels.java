public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
     
    public boolean checkRows(char[][] image, int m, int COL) {
        for(int i = 0; i < m; i++) {
            if(image[i][COL] == '1') {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean checkCols(char[][] image, int n, int ROW) {
        for(int j = 0; j < n; j++) {
            if(image[ROW][j] == '1') {
                return true;
            }
        }
        return false;
    }
     
     
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if(image == null || image.length == 0 || image[0].length == 0) {
            return -1;
        }
        
        int m = image.length;
        int n = image[0].length;
        
        // idea: search 4 times from (x, y)
        
        // 1. search left boundary
        int left = y;
        int start = 0, end = y;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(checkRows(image, m, mid)) {
                end = mid;
            } else {
                start = mid;
            }
            
        }
        if(checkRows(image, m, end)) {
            left = end;
        }
        if(checkRows(image, m, start)) {
            left = start;
        } 
        

        // 2. search right boundary
        int right = y;
        start = y; end = n-1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(checkRows(image, m, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(checkRows(image, m, start)) {
            right = start;
        }
        if(checkRows(image, m, end)) {
            right = end;
        }
        
        
        // 3. search top boundary
        int top = x;
        start = 0; end = x;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(checkCols(image, n, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(checkCols(image, n, end)) {
            top = end;
        }
        if(checkCols(image, n, start)) {
            top = start;
        } 
        
        
        // 4. search bottom boundary
        int bottom = x;
        start = x; end = m - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(checkCols(image, n, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(checkCols(image, n, start)) {
            bottom = start;
        }
        if(checkCols(image, n, end)) {
            bottom = end;
        }
        
        return ((right - left + 1) * (bottom - top + 1) );

    }
}