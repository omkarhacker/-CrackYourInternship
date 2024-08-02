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
    public boolean isPalindrome(ListNode head) {
        
        int size=findSize(head);
        int val=size/2;
        ListNode temp1=head;
        ListNode temp2=head;
        while(val>0){
            temp1=temp1.next;
            temp2=temp2.next;
            val--;
        }
        if(size%2==1){
            temp1=temp1.next;
        }
        ListNode node=temp1;
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
        ListNode reverse=findReverse(temp1);
        while(reverse!=null){
            if(reverse.val!=head.val){
                return false;
            }
            reverse=reverse.next;
            head=head.next;
        }
        return true;
    }
    public int findSize(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
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