/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1, end = n;
        SVNRepo sr = new SVNRepo();
        while(start + 1 < end) {
            int mid = start + (end-start)/2;
            if(sr.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(sr.isBadVersion(start)) {
            return start;
        }
        if(sr.isBadVersion(end)) {
            return end;
        }
        return -1;
    }
}
