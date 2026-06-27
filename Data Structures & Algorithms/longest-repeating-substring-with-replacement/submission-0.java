class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        int maxLength = 0;
        int[] counts =  new int[26];
        int maxFrequency = 0;

        while(right < s.length()){
            
            counts[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency , counts[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFrequency > k){
                // shrink till the condition becomes valid again.
                
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            
            maxLength = Math.max(maxLength , right - left + 1);
            right++;
        }

        return maxLength;
    }
}
