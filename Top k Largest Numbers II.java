public class Solution {
    
    private Queue<Integer> minheap;
    private int maxSize;
    
    public Solution(int k) {
        // initialize your data structure here.
        minheap = new PriorityQueue<>();
        maxSize = k;
    }

    public void add(int num) {
        // Write your code here
        if(minheap.size() < maxSize) {
            minheap.offer(num);
            return;
        }
        if(num > minheap.peek()) {
            minheap.poll();
            minheap.offer(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        Iterator it = minheap.iterator();
        while(it.hasNext()) {
            result.add((Integer)it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};