class Solution {
    public int singleNumber(int[] nums) {
        int checker = 0;
        for(int val : nums){
            checker ^= val;
        }

        return checker;
    }
}
