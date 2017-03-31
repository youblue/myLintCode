public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        
        int start = 0, end = n*m-1;
        
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            int i = mid/m;
            int j = mid%m;
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(matrix[start/m][start%m] == target) {
            return true;
        }
        if(matrix[end/m][end%m] == target) {
            return true;
        }
        
        return false;
    }
}
