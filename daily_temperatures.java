class Solution {
    class Node{
        int val;
        int index;
        Node(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Node>st=new Stack<>();
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek().val<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
               ans[i]=0;
            }
            else{
                ans[i]=st.peek().index-i;
            }
            st.push(new Node(temperatures[i],i));
        }
        return ans;

    }
}