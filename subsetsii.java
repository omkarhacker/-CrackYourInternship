class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>li=new ArrayList<>();
        HashSet<List<Integer>>hs=new HashSet<>();
        findAns(li,0,nums,hs);
        List<List<Integer>>ans=new ArrayList<>();
        for(List<Integer>a:hs){
            ans.add(a);
        }
        return ans;
    }
    public void findAns(List<Integer>li,int i,int nums[],HashSet<List<Integer>>hs){
        if(i>=nums.length){
            hs.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[i]);
        findAns(li,i+1,nums,hs);
        li.remove(li.size()-1);
        findAns(li,i+1,nums,hs);
    }
}