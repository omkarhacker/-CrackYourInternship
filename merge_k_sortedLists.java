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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 ){
            return null;
        }
        ListNode start=lists[0];
        for(int i=1;i<lists.length;i++){
            ListNode end=lists[i];
            ListNode ans=mergeList(start,end);
            start=ans;
        }
        return start;
    }
    public ListNode mergeList(ListNode start,ListNode end){
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        while(start!=null && end!=null){
            if(start.val<=end.val){
                ans.next=start;
                start=start.next;
            }
            else{
                ans.next=end;
                end=end.next;
            }
            ans=ans.next;
        }
        if(start!=null){
            ans.next=start;
        }
        if(end!=null){
            ans.next=end;
        }
        return dummy.next;
    }
}