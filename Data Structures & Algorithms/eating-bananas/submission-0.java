class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int val : piles){
            if(val > max){
                max = val;
            }
        }

        int start = 1;
        int end = max;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            int currTime = findTime(mid , piles);
            if(currTime > h){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start;
    }

    public int findTime(int rate , int[] piles){
        int totalTime = 0;
        for(int val : piles){
            if(val % rate == 0) totalTime += val / rate;
            else totalTime += (val / rate) + 1;
        }

        return totalTime;
    }
}
