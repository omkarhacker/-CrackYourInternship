/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode>arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            int count=1;
            ListNode temp1=temp;
            ListNode temp2=temp1;
            while(count!=k && temp2!=null && temp2.next!=null){
                temp2=temp2.next;
                count++;
            }
            if(count==k){
                temp=temp2.next;
                temp2.next=null;
                arr.add(findReverse(temp1));
            }
            else{
                arr.add(temp1);
                temp=null;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        for(int i=0;i<arr.size();i++){
            node.next=arr.get(i);
            ListNode x=arr.get(i);
            while(x.next!=null){
                x=x.next;
            }
            node=x;
        }
        return dummy.next;
    }
    public ListNode findReverse(ListNode temp){
        ListNode curr=temp;
        ListNode pre=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}