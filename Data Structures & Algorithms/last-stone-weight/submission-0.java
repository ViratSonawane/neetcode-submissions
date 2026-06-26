class Solution {
    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        
        for(int weight : stones){
            pq.offer(weight);
        }   

        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if(stone1 == stone2){
                continue;
            }
            else{
                pq.offer(Math.abs(stone1 - stone2));
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;

    }
}
