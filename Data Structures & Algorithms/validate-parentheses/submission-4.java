class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    char v = (char)stack.peek();
                    if((c == ')' && v == '(') || (c == '}' && v == '{') || (c == ']' && v == '[')){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }

        }
        
        return stack.isEmpty();

    }
}
