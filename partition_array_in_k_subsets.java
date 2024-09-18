class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	
	      int sum=0;
	      for(int i=0;i<n;i++){
	          sum=sum+a[i];
	      }
	      if(sum%k!=0){
	          return false;
	      }
	      int val=sum/k;
	      HashSet<Integer>visited=new HashSet<>();
	      return findAns(k,val,0,0,visited,a);
    }
    public boolean findAns(int k,int val,int sum,int i,HashSet<Integer>hs,int a[]){
        if(k==0){
            return true;
        }
        if(sum==val){
            return findAns(k-1,val,0,0,hs,a);
        }
        for(int j=i;j<a.length;j++){
            if(!hs.contains(j) && a[j]+sum<=val){
                hs.add(j);
                if(findAns(k,val,sum+a[j],j+1,hs,a)){
                    return true;
                }
                hs.remove(j);
            }
        }
        return false;
    }
}
