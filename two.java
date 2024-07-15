

class Solution {
    public int[] twoSum(int[] nums, int target) {
      
      HashMap<Integer,Integer>hm=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        hm.put(nums[i],i);
      }
      int ans[]=new int[2];
      for(int i=0;i<nums.length;i++){
        int val=target-nums[i];
        if(hm.containsKey(val) && hm.get(val)!=i){
            ans[0]=i;
            ans[1]=hm.get(val);
        }
      }
      return ans;
    }
}
