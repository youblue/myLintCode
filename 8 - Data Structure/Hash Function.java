public class Solution {
    /*
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long sum = 0;
        for(int i = 0; i < key.length; i++) {
            sum = (sum*33 + (int)key[i])%HASH_SIZE;
        }
        return (int)sum;
    }
}