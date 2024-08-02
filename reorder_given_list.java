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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode middle=findMiddle(head);
        ListNode temp1=findReverse(middle.next);
        middle.next=null;
        ListNode temp2=head;

        while(temp1!=null){
            ListNode val1=temp2.next;
            ListNode val2=temp1.next;
            temp2.next=temp1;
            temp1.next=val1;
            temp2=val1;
            temp1=val2;
        } 
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
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}