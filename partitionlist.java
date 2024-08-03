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
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummy1=new ListNode(-1);
        ListNode temp3=dummy1;
        ListNode dummy2=new ListNode(-1);
        ListNode temp4=dummy2;
        ListNode temp1=head;
        while(temp1!=null){
            if(temp1.val<x){
                temp3.next=temp1;
                temp3=temp3.next;
            }
            else{
                temp4.next=temp1;
                temp4=temp4.next;
            }
            temp1=temp1.next;
        }
        temp4.next=null;
        temp3.next=dummy2.next;
        return dummy1.next;
    }
}