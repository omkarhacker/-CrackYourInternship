class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>li=new ArrayList<>();
        findAns(0,target,candidates,li,ans);
        return ans;
    }
    public void findAns(int i,int target,int candidates[],List<Integer>li,List<List<Integer>>hs){
        if(target==0){
            hs.add(new ArrayList<>(li));
            return;
        }
        if(i>=candidates.length){
            return;
        }
        if(target>=candidates[i]){
            li.add(candidates[i]);
            findAns(i+1,target-candidates[i],candidates,li,hs);
            li.remove(li.size()-1);
        }
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        findAns(i+1,target,candidates,li,hs);
    }
}