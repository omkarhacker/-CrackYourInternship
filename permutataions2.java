class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>>hs=new HashSet<>();
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>li=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();
        findAns(hs,li,set,0,nums);
        for(List<Integer> a:hs){
            ans.add(a);
        }
        return ans;
    }
    public void findAns(HashSet<List<Integer>>ans,List<Integer>li,HashSet<Integer>hs,int i,int nums[]){
        if(i==nums.length){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!hs.contains(j)){
                li.add(nums[j]);
                hs.add(j);
                findAns(ans,li,hs,i+1,nums);
                li.remove(li.size()-1);
                hs.remove(j);
            }
        }
    }
}