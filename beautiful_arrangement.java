class Solution {
    public int countArrangement(int n) {
        ArrayList<Integer>arr=new ArrayList<>();
        int ans[]=new int[1];
        HashSet<Integer>hs=new HashSet<>();
        findAns(ans,arr,1,n,hs);
        return ans[0];
    }
    public void findAns(int ans[],ArrayList<Integer>arr,int i,int n,HashSet<Integer>hs){
        if(i==n+1){
       
        ans[0]++;
            return;
        }
        for(int j=1;j<=n;j++){
            if(!hs.contains(j) && (j%i==0 || i%j==0)){
                hs.add(j);
                arr.add(j);
                findAns(ans,arr,i+1,n,hs);
                hs.remove(j);
                arr.remove(arr.size()-1);
            }
        }
    }
}