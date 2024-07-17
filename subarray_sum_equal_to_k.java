import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n+1];
        arr[0]=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            arr[i+1]=sum;
        }
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int total=0;
        for(int i=1;i<=n;i++){
            int val=arr[i]-k;
            if(hm.containsKey(val)){
                int val1=hm.get(val);
                total=total+(val1);
            }
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        return total;
    }
}
