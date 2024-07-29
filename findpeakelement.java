class Solution{
    static int equalizeArray(int N, int k, int A[])
    {
        // code here
        int mod=(int)1e9+7;
        int count=0;
        int val=A[0]%k;
        for(int i=0;i<N;i++){
            if(val!=A[i]%k){
                return -1;
            }
        }
        Arrays.sort(A);
        int val1=A[N/2];
        for(int i=0;i<N;i++){
            int diff=Math.abs(val1-A[i]);
            count=(count+diff/k)%mod;
        }
        return count;
    }
}