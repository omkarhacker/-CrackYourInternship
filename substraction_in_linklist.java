class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        Node temp1 = removeLeadingZeros(head1);
        Node temp2 = removeLeadingZeros(head2);
        int len1=findLeng(temp1);
        int len2=findLeng(temp2);
        if(len1==len2){
            Node x=temp1;
            Node y=temp2;
            while(x!=null && y!=null && x.data==y.data){
                x=x.next;
                y=y.next;
            }
            if(x==null && y==null){
                return new Node(0);
            }
            if(x.data>y.data){
                return findAns(temp1,temp2);
            }
            else{
                return findAns(temp2,temp1);
            }
        }
        else{
            if(len1>len2){
                return findAns(temp1,temp2);
            }
            else{
                return findAns(temp2,temp1);
            }
        }
    }
    public Node findAns(Node temp1, Node temp2) {
        // Reverse both lists
        Node reversed1 = reverseList(temp1);
        Node reversed2 = reverseList(temp2);
        
        Node dummy = new Node(-1);
        Node ans = dummy;
        int carry = 0;
        
        while (reversed1 != null) {
            int val1 = reversed1.data;
            int val2 = (reversed2 != null) ? reversed2.data : 0;
            
            int diff = val1 - val2 - carry;
            carry = (diff < 0) ? 1 : 0;
            if (diff < 0) diff += 10;
            
            ans.next = new Node(diff);
            ans = ans.next;
            
            reversed1 = reversed1.next;
            if (reversed2 != null) reversed2 = reversed2.next;
        }
        
        // Remove leading zeros from result
        Node result = reverseList(dummy.next);
        return removeLeadingZeros(result);
    }
    private Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return (head == null) ? new Node(0) : head;
    }
    public Node reverseList(Node temp){
        Node curr=temp;
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
    public int findLeng(Node list){
        int count=0;
        while(list!=null){
            list=list.next;
            count++;
        }
        return count;
    }
}