class MinStack {

    private Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    


    // 5 4 3 2 1
    // min = 1
    // on 3



//5 1 2 10 11

//


// 11 10 2 1 5



    public int getMin() {
        // if(s.isEmpty()){
        //     return 0;
        // }
        //the problem here is that i'm editing the actual stack inside this class when i shouldn't be doing that
        //i think the issue now is that my stack is reversed

        Stack<Integer> e = new Stack<>();

        
        int min = st.peek();
        while(!st.isEmpty()){
            e.push(st.peek());
            if(st.peek() < min){
                min = st.peek();
            }
            st.pop();
            
        }
        while(!e.isEmpty()){
            st.push(e.pop());
        }
        return min;
        // return 5;
    }
}
