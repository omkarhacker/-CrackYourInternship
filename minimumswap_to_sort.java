class Solution
{
    class Node{
        int val;
        int index;
        Node(int first,int second){
            this.val=first;
            this.index=second;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n=nums.length;
        Node arr[]=new Node[n];
        for(int i=0;i<n;i++){
            arr[i]=new Node(nums[i],i);
        }
        Arrays.sort(arr,Comparator.comparingDouble(Node->Node.val));
        boolean visited[]=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                Node node=arr[i];
                int val=node.val;
                int index=node.index;
                if(index==i){
                    visited[i]=true;
                    continue;
                }
                int count=0;
                while(!visited[index]){
                    Node node1=arr[index];
                    visited[index]=true;
                    index=node1.index;
                    count++;
                }
                ans=ans+count-1;
            }
        }
        return ans;
    }
    
    
}