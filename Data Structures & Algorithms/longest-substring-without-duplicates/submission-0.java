class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        int maxLength = 0;
        int currLength = 0;

        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            
            while(set.contains(s.charAt(right))){
               set.remove(s.charAt(left));
               left++;
            }

            set.add(s.charAt(right));
            currLength = right - left + 1;
            maxLength = Math.max(maxLength , currLength);
            right++;
        }

        return maxLength;
    }
}
