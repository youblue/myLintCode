class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
public:
    vector<int> searchRange(vector<int> &A, int target) {
        // write your code here
        vector<int>answer;
        if(A.size() == 0){
            answer.push_back(-1);
            answer.push_back(-1);
            return answer;
        }
        
        // find first
        int start = 0, end = A.size()-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(A[mid] == target){
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[start] == target){
            answer.push_back(start);
        }else if(A[end] == target){
            answer.push_back(end);
        }else{
            answer.push_back(-1);
        }
        
        // find last
        start = 0; end = A.size()-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(A[mid] == target){
                start = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[end] == target){
            answer.push_back(end);
        }else if(A[start] == target){
            answer.push_back(start);
        }else{
            answer.push_back(-1);
        }
        
        return answer;

    }
};