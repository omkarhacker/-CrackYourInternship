class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer>li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                li.add(Math.abs(nums[i]));
            }
            nums[index]=-nums[index];
        }
        return li;
    }
}