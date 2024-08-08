class Solution {
    class Node{
        char ch;
        int count;
        Node(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek().ch==ch){
                Node node=st.pop();
                node.count=node.count+1;
                st.push(node);f
                if(node.count==k){
                    st.pop();
                }
            }
            else{
                st.push(new Node(ch,1));
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            Node node=st.pop();
            int val=node.count;
            while(val-->0){
                ans.append(node.ch);
            }
        }
        return ans.reverse().toString();
    }
}