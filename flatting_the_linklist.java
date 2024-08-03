class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        Node head=root;
        Node start=root;
        Node end=head.next;
        head=head.next;
        while(end!=null){
            Node ans=mergeNode(start,end);
            start=ans;
            end=head.next;
            head=head.next;
        }
        return start;
    }
    Node mergeNode(Node start,Node end){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(start!=null && end!=null){
            if(start.data<=end.data){
                temp.bottom=start;
                start=start.bottom;
            }
            else{
                temp.bottom=end;
                end=end.bottom;
            }
            temp=temp.bottom;
        }
        if(start!=null){
            temp.bottom=start;
        }
        if(end!=null){
            temp.bottom=end;
        }
        return dummy.bottom;
    }
}