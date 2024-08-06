class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=(int)1e9+7;
        int left[]=new int[n];
        int right[]=new int[n];
        findLeft(left,arr);
        findRight(right,arr);
        for(int i=0;i<n;i++){
            System.out.println(left[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println(right[i]);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long val=(arr[i]*((long)(i-left[i])*(long)(right[i]-i)))%mod;
            ans=(ans+val+mod)%mod;
        }
        return (int)ans;
    }
    public void findLeft(int left[],int arr[]){
         Stack<Integer>st=new Stack<>();
        for(int i=0;i<left.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
    }
    public void findRight(int left[],int arr[]){
        Stack<Integer>st=new Stack<>();
        for(int i=left.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=arr.length;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
    }

}