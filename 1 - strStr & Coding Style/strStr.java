class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null) {
            return -1;
        }
        
        int i = 0;
        while(i < source.length() - target.length() + 1) {
            int j = 0;
            while(j < target.length()) {
                if(source.charAt(i+j) != target.charAt(j)) {
                    break;
                } else {
                    j++;
                }
            }
            if(j == target.length()) {
                return i;
            }
            i++;
        }
        
        return -1;
    }
}