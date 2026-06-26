class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int val : nums){
            currSum += val; // add
            maxSum = Math.max(maxSum , currSum); // record

            if(currSum < 0){ // update if sum goes negative
                currSum = 0;
            }
        }

        return maxSum;
    }
}
