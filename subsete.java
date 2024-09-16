

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>>hs=new HashSet<>();
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>li=new ArrayList<>();
        findAns(nums,hs,li,0);
        for(List<Integer>a:hs){
            ans.add(a);
        }
        return ans;
    }
    public void findAns(int nums[],HashSet<List<Integer>>ans,List<Integer>li,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }
            li.add(nums[i]);
            findAns(nums,ans,li,i+1);
            li.remove(li.size()-1);
            findAns(nums,ans,li,i+1);
    }
}
