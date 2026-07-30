class MinStack {

    int[] stack=new int[30000];
    int[] minStack=new int[30000];
    int top=-1;
    int minTop=-1;

    public MinStack() {

        
    }
    
    public void push(int value) {
        stack[++top]=value;
        if(minTop==-1 || value<=minStack[minTop]){
            minStack[++minTop]=value;
        }
    }
    
    public void pop() {
        if(stack[top--]==minStack[minTop]){
            minTop--;
        }
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[minTop];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */