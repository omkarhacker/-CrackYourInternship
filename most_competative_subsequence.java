class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
       int n=nums.length;
        
      Stack<Integer>st=new Stack<>();
      for(int i=0;i<n;i++){
          while(!st.isEmpty() && nums[i]<st.peek() && (n+st.size()-i)>k){
              st.pop();
          }
          if(st.size()<k){
            st.push(nums[i]);
          }
      }
      int ans[]=new int[k];
      int i=k-1;
      while(!st.isEmpty()){
           ans[i]=st.pop();
           i--;
      }
      return ans;
    }
}