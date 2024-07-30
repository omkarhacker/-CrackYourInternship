class Solution {
    class Node{
        int first;
        int index;
        Node(int first,int index){
            this.first=first;
            this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        Node newarr[]=new Node[n];
        for(int i=0;i<n;i++){
            newarr[i]=new Node(nums[i],i);
        }
        divideArray(ans,newarr,0,n-1);
        List<Integer>li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(ans[i]);
        }
        return li;
    }
    public void divideArray(int ans[],Node nums[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        divideArray(ans,nums,start,mid);
        divideArray(ans,nums,mid+1,end);
        merge(ans,nums,start,mid,end);
    }
    public void merge(int ans[],Node nums[],int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int k=0;
        Node temp[]=new Node[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i].first<=nums[j].first){
                temp[k]=nums[j];
                j++;
                k++;
            }
            else{
                temp[k]=nums[i];
                ans[nums[i].index]=ans[nums[i].index]+end-j+1;
                k++;
                i++;
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=end){
            temp[k++]=nums[j++];
        }
        int x=0;
        for(int p=start;p<=end;p++){
            nums[p]=temp[x];
            x++;
        }
    }
}