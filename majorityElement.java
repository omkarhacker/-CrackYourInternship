class Solution {
    public int majorityElement(int[] nums) {
       
       int n=nums.length;
       int val=(n+1)/2;

       HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<n;i++){
         hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
       }
       Set<Integer>set=hm.keySet();
       for(Integer it:set){
          if(hm.get(it)>=val){
            return it;
          }
       }
       return -1;
    }
}