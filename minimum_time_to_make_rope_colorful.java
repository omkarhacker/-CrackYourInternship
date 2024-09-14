class Solution {
    class Node{
        int val;
        char ch;
        Node(int val,char ch){
            this.val=val;
            this.ch=ch;
        }
    }
    public int minCost(String colors, int[] neededTime) {
        Stack<Node>st=new Stack<>();
        int total=0;
        for(int i=0;i<colors.length();i++){
            char ch=colors.charAt(i);
            int val=neededTime[i];
            while(!st.isEmpty() && st.peek().ch==ch && st.peek().val<=val){
                total=total+st.pop().val;
            }
            if(!st.isEmpty() && st.peek().ch==ch && st.peek().val>val){
                total=total+val;
                continue;
            }
            else{
                st.push(new Node(val,ch));
            }
        }
        return total;
    }
}