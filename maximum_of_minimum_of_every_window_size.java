class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        int left[]=new int[n];
        int right[]=new int[n];
        findLeft(left,n,arr);
        findRight(right,n,arr);
        int ans[]=new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            ans[width - 1] = Math.max(ans[width - 1], arr[i]);
        }
    
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        return ans;
    }
    static void findLeft(int left[],int n,int arr[]){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
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
    static void findRight(int left[],int n,int arr[]){
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=n;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
    }
}