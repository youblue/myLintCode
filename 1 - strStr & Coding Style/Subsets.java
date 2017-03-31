class Solution {
    
      @param S A set of numbers.
      @return A list of lists. All valid subsets.
     
    public ArrayListArrayListInteger subsets(int[] nums) {
         write your code here
        ArrayListArrayListInteger  result = new ArrayList();
        
        if(nums == null  nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        helper(result, nums, new ArrayListInteger(), 0);
        
        return result;
    }
    
    public static void helper(ArrayListArrayListInteger result,
                              int[] nums,
                              ArrayListIntegersubset,
                              int startIndex) {
        
        result.add(new ArrayListInteger(subset));
        
        for(int i = startIndex; i  nums.length; i++) {
            subset.add(nums[i]);
            helper(result, nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
        
                                  
    }
    
}