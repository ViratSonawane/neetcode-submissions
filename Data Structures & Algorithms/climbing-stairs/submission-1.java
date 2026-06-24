class Solution {
    public int climbStairs(int n) {
        if(n <= 3){
            return n;
        }
        int prevprev = 2;
        int prev = 3;
        int result = 0;

        for(int i = 4; i <= n; i++){
            result = prevprev + prev;
            prevprev = prev;
            prev = result; 
        }

        return result;
    }
}
