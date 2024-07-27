public class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==1){
                    if(i>0){
                        M[i][j]=M[i-1][j]+1;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,findArea(M[i],m));
        }
        return max;
    }
    public int findArea(int arr[],int n){
        int left[]=new int[n];
        int right[]=new int[n];
        findLeft(left,arr,n);
        findRight(right,arr,n);
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(right[i]-left[i]-1)*arr[i]);
        }
        return ans;
    }
    public void findLeft(int left[],int arr[],int n){
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
    public void findRight(int left[],int arr[],int n){
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
} {
    
}
