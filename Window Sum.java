public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        int[]empty = {};
        if(nums == null || nums.length == 0 || k == 0) {
            return empty;
        }
        
        if(k >= nums.length) {
            int[] result = new int[1];
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            result[0] = sum;
            return result;
        }
        
        int[] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; i++) {
            int sum = 0;
            for(int j = 0; j < k; j++) {
                sum += nums[i+j];
            }
            result[i] = sum;
        }
        
        return result;
    }
}

