class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        
        ArrayList<ArrayList<Integer> >result = new ArrayList<>();
        /*
        if(nums == null || nums.length == 0) {
            return result;
        }
        */
        Arrays.sort(nums);
        
        helper(result, nums, new ArrayList<Integer>(), 0);
        
        return result;
    }
    
    public static void helper(ArrayList<ArrayList<Integer> >result,
                              int[] nums,
                              ArrayList<Integer>subset,
                              int startIndex) {
    
        if(!result.contains(subset) ) {
            result.add(new ArrayList<Integer>(subset));
        }
        
        for(int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(result, nums, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
    
}
