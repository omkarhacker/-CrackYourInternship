class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        int count0=0;
        int count1=0;
        int count2=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                count0++;
            }
            else if(temp.data==1){
                count1++;
            }
            else{
                count2++;
            }
            temp=temp.next;
        }
        
        Node duplicate=new Node(-1);
        Node temp1=duplicate;
        while(count0>0){
            Node val=new Node(0);
            temp1.next=val;
            temp1=temp1.next;
            count0--;
        }
        while(count1>0){
            Node val=new Node(1);
            temp1.next=val;
            temp1=temp1.next;
            count1--;
        }
        while(count2>0){
            Node val=new Node(2);
            temp1.next=val;
            temp1=temp1.next;
            count2--;
        }
        temp1.next=null;
        return duplicate.next;
        
    }
}
