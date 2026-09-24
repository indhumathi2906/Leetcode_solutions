class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int st: stones)
        {
            maxHeap.add(st);
        }
        while(maxHeap.size()>=2)
        {
            int y=maxHeap.poll();
            int x=maxHeap.poll();
            if(x==y)
            {
                continue;
            }
            if(y!=x)
            {
                maxHeap.add(y-x);
            }
        }
        return maxHeap.size()==1 ? maxHeap.peek() : 0;
    }
}