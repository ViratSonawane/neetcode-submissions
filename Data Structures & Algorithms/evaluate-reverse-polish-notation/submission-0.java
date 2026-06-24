class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String c = tokens[i];

            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                String operanda = stack.pop();
                String operandb = stack.pop();

                int op2 = Integer.parseInt(operanda);
                int op1 = Integer.parseInt(operandb);
                int result = 0;

                if(c.equals("+")){
                    result = op1 + op2;
                }
                else if(c.equals("-")){
                    result = op1 - op2;
                }
                else if(c.equals("*")){
                    result = op1 * op2;
                }
                else if(c.equals("/")){
                    result = op1 / op2;
                }

                stack.push(result + "");
            }
            else{
                stack.push(c);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
