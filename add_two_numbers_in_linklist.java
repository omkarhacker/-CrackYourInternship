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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode node1=l1;
        ListNode node2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(node1!=null && node2!=null){
            int val=node1.val+node2.val+carry;
            if(val>=10){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
                carry=1;
            }
            else{
                ListNode node=new ListNode(val);
                temp.next=node;
                temp=temp.next;
                carry=0;
            }
            node1=node1.next;
            node2=node2.next;
        }
        while(node1!=null){
            int val=node1.val+carry;
            if(val>=10){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
                carry=1;
            }
            else{
                ListNode node=new ListNode(val);
                temp.next=node;
                temp=temp.next;
                carry=0;
            }
            node1=node1.next;
        }
        while(node2!=null){
            int val=node2.val+carry;
            if(val>=10){
                ListNode node=new ListNode(val%10);
                temp.next=node;
                temp=temp.next;
                carry=1;
            }
            else{
                ListNode node=new ListNode(val);
                temp.next=node;
                temp=temp.next;
                carry=0;
            }
            node2=node2.next;
        }
        if(carry==1){
            ListNode node=new ListNode(1);
            temp.next=node;
            temp=temp.next;
        }
        temp.next=null;
        return dummy.next;

    }
    public ListNode findReverse(ListNode li){
        ListNode curr=li;
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