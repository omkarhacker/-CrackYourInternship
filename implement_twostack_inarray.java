class twoStacks {
    Stack<Integer>st1;
    Stack<Integer>st2;
    twoStacks() {
        st1=new Stack<>();
        st2=new Stack<>();
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        st1.push(x);
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        st2.push(x);
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(st1.isEmpty()){
            return -1;
        }
        else{
           return st1.pop();
        }
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(st2.isEmpty()){
            return -1;
        }
        return st2.pop();
    }
}