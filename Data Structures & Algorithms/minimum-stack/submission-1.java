class MinStack {
    public Stack<Integer> mainStack;
    public Stack<Integer> minStack;
    
    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
            return;
        }
        int checker = (int)minStack.peek();
        if(val <= checker){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int popper = (int)mainStack.peek();
        int checker = (int)minStack.peek();
        if(popper == checker){
            mainStack.pop();
            minStack.pop();
        }
        else{
            mainStack.pop();
        }
    }
    
    public int top() {
        return (int)mainStack.peek();
    }
    
    public int getMin() {
        return (int)minStack.peek();
    }
}
