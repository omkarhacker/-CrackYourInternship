class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        //  The task is to complete this method
        if(head==null || head.next==null){
            return;
        }
        Node odd=new Node(-1);
        Node even=new Node(-1);
        Node temp1=odd;
        Node temp2=even;
        Node temp=head;
        boolean istrue=true;
        while(temp!=null){
            if(istrue){
                temp1.next=temp;
                temp1=temp1.next;
                istrue=false;
            }
            else{
                temp2.next=temp;
                temp2=temp2.next;
                istrue=true;
            }
            temp=temp.next;
        }
        temp1.next=even.next;
        temp2.next=null;
        return;
    }
}
