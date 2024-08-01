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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode duplicate=new ListNode(-1);
        ListNode node=duplicate;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                 node.next=temp1;
                 node=node.next;
                 temp1=temp1.next;
            }
            else{
                node.next=temp2;
                node=node.next;
                temp2=temp2.next;
            }
        }
        if(temp1!=null){
            node.next=temp1;
        }
        if(temp2!=null){
            node.next=temp2;
        }
        return duplicate.next;
    }
}