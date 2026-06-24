class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            result[i] = bitsCounter(i);
        }   

        return result;
    }

    public int bitsCounter(int n){
        int bits = 0;
        while(n > 0){
            if(n % 2 == 1){
                bits++;
            }

            n /= 2;
        }

        return bits;
    }
}
