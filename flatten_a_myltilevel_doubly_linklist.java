/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node>st=new Stack<>();
        return findAns(head,st);
    }
    public Node findAns(Node head,Stack<Node>st){
        Node temp=head;
        while(temp!=null){
            if(temp.child==null){
                temp=temp.next;
            }
            else{
                if(temp.next!=null){
                    st.push(temp.next);
                }
                Node newNext=findAns(temp.child,st);
                temp.next=newNext;
                newNext.prev=temp;
                temp.child=null;
                Node x=newNext;
                while(x.next!=null){
                    x=x.next;
                }
                if(x.next==null && !st.isEmpty()){
                     Node y=st.pop();
                     x.next=y;
                     y.prev=x;
                     x=x.next;
                }
                else{
                    x=x.next;
                }
               
            }
        }
        return head;
    }
}