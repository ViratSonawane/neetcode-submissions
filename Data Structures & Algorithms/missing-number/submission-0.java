class Solution {
    public int missingNumber(int[] nums) {
        int arrSum = 0;
        int actualSum = 0;
        for(int i = 1; i <= nums.length; i++){
            arrSum += nums[i-1];
            actualSum += i;
        }

        return actualSum - arrSum;
    }
}
