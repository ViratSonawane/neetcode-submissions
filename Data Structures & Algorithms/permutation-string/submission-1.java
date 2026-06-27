class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n){
            return false;
        }

        int left = 0;
        int right = m - 1;

        int[] frequency = new int[26];
        for(int i = 0; i < m; i++){
            frequency[s1.charAt(i) - 'a']++;
        }

        int[] currFrequency = new int[26];
        for(int i = left; i <= right; i++){
            currFrequency[s2.charAt(i) - 'a']++;
        }

        while(right < n){
            if(checkArrays(frequency , currFrequency)){
                return true;
            }
            else{
                currFrequency[s2.charAt(left) - 'a']--;
                left++;
                right++;

                if(right < n){
                    currFrequency[s2.charAt(right) - 'a']++;
                }
            }

        }

        return false;
    }

    public boolean checkArrays(int[] arr1 , int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
