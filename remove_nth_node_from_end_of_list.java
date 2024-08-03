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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode temp1=findReverse(head);
       ListNode ans=temp1;
       if(n==1){
          ans=ans.next;
          return findReverse(ans);
       }
       else{
        int count=1;
        n--;
        while(count!=n && temp1!=null){
            temp1=temp1.next;
            count++;
        }
        temp1.next=temp1.next.next;
        return findReverse(ans);
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
}