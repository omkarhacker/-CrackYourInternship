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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        ListNode temp1=dummy;
        int count=1;
        while(temp!=null && count!=left){
            temp1.next=temp;
            temp1=temp1.next;
            temp=temp.next;
            count++;
        }
        if(temp==null){
            return head;
        }
        ListNode reverse=temp;
        ListNode node=reverse;
        while(count!=right){
            node=node.next;
            temp=temp.next;
            count++;
        }
        temp=temp.next;
        node.next=null;
        ListNode rever=findReverse(reverse);
        temp1.next=rever;
        ListNode findEnd=rever;
        while(findEnd.next!=null){
            findEnd=findEnd.next;
        }
        findEnd.next=temp;
        return dummy.next;
    }
    public ListNode findReverse(ListNode head){
        ListNode curr=head;
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