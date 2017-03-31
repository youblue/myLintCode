public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        if(org == null) {
            if(seqs == null) {
                return true;
            } else {
                return false;
            }
        } else if(org.length == 0) {
            if(seqs.length == 0) {
                return true;
            } else {
                return true;
            }
            
        } else if(seqs == null || seqs.length == 0 || seqs[0].length == 0) {
            return false;
        }
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < seqs.length; i++) {
            for(int j = 0; j < seqs[i].length; j++) {
                if(map.containsKey(seqs[i][j])) {
                    map.put(seqs[i][j], Math.max(j, map.get(seqs[i][j])));
                } else {
                    map.put(seqs[i][j], j);
                }
            }
        }
        
        if(map.size() != org.length) {
            return false;
        }

        
        for(int i = 0; i < seqs.length; i++) {
            int start = map.get(seqs[i][0]);
            for(int j = 1; j < seqs[i].length; j++) {
                map.put(seqs[i][j], Math.max(start + j, map.get(seqs[i][j])));
            }
        }
        
        for(int i = 0; i < seqs.length; i++) {
            int start = map.get(seqs[i][0]);
            for(int j = 1; j < seqs[i].length; j++) {
                map.put(seqs[i][j], Math.max(start + j, map.get(seqs[i][j])));
            }
        }

        int[] array = new int[org.length];
        for(int i = 0; i < org.length; i++) {
            array[i] = map.get(org[i]);
            //System.out.println(array[i]);
        }
        Arrays.sort(array);
        for(int i = 0; i < array.length;i++) {
            //System.out.println(org[i]);
           // System.out.println(array[i]);
        } 
        
        for(int i = 0; i < array.length; i++) {
            //System.out.println(i);
            //System.out.println(array[i]);
            if(array[i] != i) {
                //System.out.println(i);
                //System.out.println(array[i]);
                return false;
            }
        }
        
        return true;
    }
}