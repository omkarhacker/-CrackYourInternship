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
    public ListNode sortList(ListNode head) {
       return findSorted(head);
    }
    public ListNode findSorted(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        else{
            ListNode mid=findMid(head);
            ListNode end=mid.next;
            mid.next=null;
            ListNode left=findSorted(head);
            ListNode right=findSorted(end);
            return mergeNode(left,right);
        }
    }
    public ListNode mergeNode(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                node.next=head1;
                head1=head1.next;
            }
            else{
                node.next=head2;
                head2=head2.next;
            }
            node=node.next;
        }
        if(head1!=null){
            node.next=head1;
        }
        if(head2!=null){
            node.next=head2;
        }
        return dummy.next;
    }
    public ListNode findMid(ListNode li){
        ListNode slow=li;
        ListNode fast=li;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}