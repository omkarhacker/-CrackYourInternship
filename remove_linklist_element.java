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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode temp=head;
        ListNode duplicate=new ListNode(-1);
        ListNode node=duplicate;
        while(temp!=null){
            if(temp.val!=val){
                node.next=temp;
                temp=temp.next;
                node=node.next;
            }
            else{
                temp=temp.next;
            }
        }
        node.next=null;
        return duplicate.next;
    }
}