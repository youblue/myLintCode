public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return nums[mid];
            } else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
                start = mid;
            } else if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]) {
                end = mid;
            }
        }
        if(start == 0) {
            if(nums[start] > nums[end]) {
                return nums[start];
            } else {
                return nums[end];
            }
            
        } else if(nums[start] > nums[start-1] && nums[start] > nums[start+1]) {
            return nums[start];
        } else if(nums[end] > nums[end-1] && nums[end] > nums[end+1]) {
            return nums[end];
        }
        
        return -1;
    }
}