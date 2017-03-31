public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0; int end = A.length-1;
        while(start+1 < end){
            int mid = (start + end)/2;
            if (A[mid] == target){
                return mid;
            }else if (A[mid] < target){
                start = mid;
            }else{
                end = mid;
            } 
        }
        if (A[end] < target){
            return end;
        }else if(target-A[start] < A[end]-target){
            return start;
        }else return end;
    }
            
}
