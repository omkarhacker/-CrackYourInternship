class Solution {
    Node divide(Node head) {
        // code here
        Node dummy1=new Node(-1);
        Node dummy2=new Node(-1);
        Node temp1=dummy1;
        Node temp2=dummy2;
        Node temp=head;
        while(temp!=null){
            if(temp.data%2==0){
                temp1.next=temp;
                temp1=temp1.next;
            }
            else{
                temp2.next=temp;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        temp1.next=dummy2.next;
        temp2.next=null;
        return dummy1.next;
    }
}