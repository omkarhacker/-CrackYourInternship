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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode temp1=dummy;
        ListNode temp=head;
        int pre=-101;
        while(temp!=null){
            if(temp.val!=pre){
                if((temp.next!=null && temp.next.val!=temp.val)|| (temp.next==null)){
                   temp1.next=temp;
                   temp1=temp1.next;
                }
            }
            pre=temp.val;
            temp=temp.next;
        }
        temp1.next=null;
        return dummy.next;
    }
}