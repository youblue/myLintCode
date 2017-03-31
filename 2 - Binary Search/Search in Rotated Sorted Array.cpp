class Solution {
    /** 
     * param A : an integer ratated sorted array
     * param target :  an integer to be searched
     * return : an integer
     */
public:
    int search(vector<int> &A, int target) {
        // write your code here
        if(A.size() == 0){
            return -1;
        }
        int start = 0, end = A.size()-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[start] <= A[mid]){
                if(A[start] <= target && A[mid] > target){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(A[mid] < target && A[end] >= target){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(A[start] == target){
            return start;
        }
        if(A[end] == target){
            return end;
        }
        
        return -1;
    }
};