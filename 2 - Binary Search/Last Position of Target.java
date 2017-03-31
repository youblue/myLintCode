public class Solution {
    
      @param nums An integer array sorted in ascending order
      @param target An integer
      @return an integer
     
    public int lastPosition(int[] nums, int target) {
         Write your code here
        if(nums == null  nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start + 1  end) {
            int i = start + (end-start)2;
            if (nums[i] = target){
                start = i;
            }else end = i;
        }
        if (nums[end] == target){
            return end;
        }else if (nums[start] == target){
            return start;
        }else return -1;
    }
}