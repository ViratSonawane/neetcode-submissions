class Solution {
    public String minWindow(String s, String t) {
        // 1. Setup our requirements using an ASCII array
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        // 'count' tracks how many characters we STILL need to match
        int count = t.length(); 
        
        int left = 0;
        int right = 0;
        
        // Track the best answer
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // 2. Sliding Window Loop
        while (right < s.length()) {
            // STEP 1: EXPAND - Process the right character
            char rightChar = s.charAt(right);
            
            // If this character is one we need, decrease our required count
            if (map[rightChar] > 0) {
                count--;
            }
            // Decrease the map requirement (can go negative if we have extra copies of a letter)
            map[rightChar]--; 
            right++; // Move right pointer forward

            // STEP 2: SHRINK - We do this WHILE the window is VALID (count == 0)
            while (count == 0) {
                // Update our minimum answer if this valid window is the smallest we've seen
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                // Now try to shrink the window from the left
                char leftChar = s.charAt(left);
                
                // Put the character back into our requirements map
                map[leftChar]++;
                
                // If the requirement for this character becomes > 0, it means we just 
                // kicked out a character we actually needed! The window is now INVALID.
                if (map[leftChar] > 0) {
                    count++; 
                }
                
                left++; // Move left pointer forward
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}