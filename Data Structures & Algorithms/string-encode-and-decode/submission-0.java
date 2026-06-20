class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length() + "#");
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            StringBuilder digits = new StringBuilder();
            
            while(str.charAt(i) != '#'){
                digits.append(str.charAt(i));
                i++;
            }
            i++;

            int length = Integer.parseInt(digits.toString());
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < length; j++){
                sb.append(str.charAt(i));
                i++;
            }

            result.add(sb.toString());
            i--;
        }

        return result;
    }
}
