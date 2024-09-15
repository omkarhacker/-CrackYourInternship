class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer>li=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        findAns(1,n,k,li,ans);
        return ans;
    }
    public void findAns(int i,int n,int k,List<Integer>li,List<List<Integer>>ans){
         if(k==0){
            ans.add(new ArrayList<>(li));
            return;
         }
         if(i>n){
            return;
         }
         li.add(i);
         findAns(i+1,n,k-1,li,ans);
         li.remove(li.size()-1);
         findAns(i+1,n,k,li,ans);
    }
}