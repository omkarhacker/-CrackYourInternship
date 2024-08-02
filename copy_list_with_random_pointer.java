/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy=new Node(-1);
        Node temp=head;
        Node temp1=dummy;
        int index=0;
        HashMap<Node,Node>hm=new HashMap<>();
        while(temp!=null){
            Node newnode=new Node(temp.val);
            temp1.next=newnode;
            temp1=temp1.next;
            hm.put(temp,temp1);
            index++;
            temp=temp.next;
        }
        Node temp2=head;
        Node temp3=dummy.next;
        while(temp2!=null){
            if(temp2.random==null){
               temp3.random=null;
            }
            else{
                temp3.random=hm.get(temp2.random);
            }
            temp2=temp2.next;
            temp3=temp3.next;
        }
        return dummy.next;
    }
}