class Solution {
    
    public Node sort(Node head){
         //your code here, return the head of the sorted list
         if(head==null || head.next==null){
             return head;
         }
         
         Node temp1=head;
         Node temp2=head.next;
         Node duplicate1=new Node(-1);
         Node duplicate2=new Node(-1);
         Node temp11=duplicate1;
         Node temp21=duplicate2;
         while(temp1!=null){
             temp11.next=new Node(temp1.data);
              temp11=temp11.next;
             if(temp1.next==null){
                 break;
             }
             temp1=temp1.next.next;
            
         }
         while(temp2!=null){
             temp21.next=new Node(temp2.data);
             temp21=temp21.next;
             if(temp2.next==null){
                 break;
             }
             temp2=temp2.next.next;
             
         }
         Node reverse=findReverse(duplicate2.next);
        
         temp11.next=reverse;
         return duplicate1.next;
         
    }
    public Node findReverse(Node head){
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