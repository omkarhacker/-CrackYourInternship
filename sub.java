class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n + 1];
        prefix[0] = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + nums[i - 1];
            int val = sum % k;
            if (val < 0) {
                val = val + k;
            }
            prefix[i] = val;
        }

        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<=n;i++){
            hm.put(prefix[i],hm.getOrDefault(prefix[i],0)+1);
        }

        Set<Integer>set=hm.keySet();
        int ans=0;
        for(Integer it:set){
            int val=hm.get(it);
           ans=ans+(val*(val-1))/2;
        }
        return ans;

    }
}