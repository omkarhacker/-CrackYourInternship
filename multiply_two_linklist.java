class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long mod=(int)1e9+7;
        long val1=0;
        while(first!=null){
            val1=(val1*10+first.data)%mod;
            first=first.next;
        }
        long val2=0;
        while(second!=null){
            val2=(val2*10+second.data)%mod;
            second=second.next;
        }
        return (val1*val2)%mod;
    }
}