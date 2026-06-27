class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int maximumProfit = 0;
        int currProfit = 0;

        while(right < prices.length){
            currProfit = prices[right] - prices[left];

            if(prices[right] < prices[left]){
                left = right;
            }

            maximumProfit = Math.max(maximumProfit , currProfit);
            right++;
        }

        return maximumProfit;
    }
}
