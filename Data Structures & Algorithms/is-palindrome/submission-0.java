class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String correctedString = sb.toString();

        int left = 0;
        int right = correctedString.length() - 1;

        while(left <= right){
            if(correctedString.charAt(left) != correctedString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
