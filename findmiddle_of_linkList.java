class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int n=findSize(temp);
        int val=n/2;
        while(temp!=null){
            if(val==0){
                return temp;
            }
            temp=temp.next;
            val--;
           
        }
        return null;
    }
    public int findSize(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}