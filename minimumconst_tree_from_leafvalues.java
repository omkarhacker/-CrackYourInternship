class Solution {
    class Node{
        int first;
        int second;
        Node(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        Node dp[][]=new Node[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],new Node(-1,-1));
        }
        return findAns(0,arr.length-1,arr,dp).second;
    }

    private Node findAns(int left, int right,int arr[],Node dp[][]) {
        
        if(left==right){
            return new Node(arr[left],0);
        }
        if(dp[left][right].first!=-1 && dp[left][right].second!=-1){
            return dp[left][right];
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=left;i<right;i++){
            Node node1=findAns(left,i,arr,dp);
            Node node2=findAns(i+1,right,arr,dp);
            max=Math.max(max,Math.max(node1.first,node2.first));
            min=Math.min(min,node1.first*node2.first+node1.second+node2.second);
        }

        return dp[left][right]=new Node(max,min);
    }

    
}
