class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        Stack<Integer>st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                hm.put(nums2[i],-1);
            }
            else{
                hm.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        int n=nums1.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}