class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        int presum[]=new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+arr[i-1];
            presum[i]=sum;
        }
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=0;
        for(int i=0;i<=n;i++){
            //System.out.println(presum[i]);
            if(hm.containsKey(presum[i])){
                max=Math.max(max,i-hm.get(presum[i]));
            }
            else{
                hm.put(presum[i],i);
            }
        }
        return max;
    }
}