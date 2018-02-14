class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        
        int n = nums.length;
        int left = 0;
        int right = n-1;
        for(int i = 0; i <= right; i++) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
            } else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
            }
        }
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}