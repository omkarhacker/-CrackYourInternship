class Solution
{
    Node compute(Node head)
    {
        // your code here
        Node reverse=findReverse(head);
        Node temp1=reverse;
        Node temp2=reverse.next;
        while(temp2!=null){
            while(temp2!=null && temp2.data<temp1.data){
                temp2=temp2.next;
            }
            temp1.next=temp2;
            temp1=temp1.next;
            if(temp2!=null){
                 temp2=temp2.next;
            }
        }
        return findReverse(reverse);
    }
    Node findReverse(Node head){
        Node curr=head;
        Node pre=null;
        Node next=null;
        while(curr!=null){
           next=curr.next;
           curr.next=pre;
           pre=curr;
           curr=next;
        }
        return pre;
    }
}