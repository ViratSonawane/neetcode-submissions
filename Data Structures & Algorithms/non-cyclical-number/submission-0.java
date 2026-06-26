class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {

        if(n == 1){
            return true;
        }
        if(set.contains(n)){
            return false;
        }
        
        set.add(n);
            
        int number = 0;
        while(n > 0){
            int lastDigit = n % 10;
            number += lastDigit * lastDigit;
            n /= 10;
        }

        return isHappy(number);
        
    }
}
