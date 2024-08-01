class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        
        Arrays.sort(arr);
        int n=arr.length;
        HashSet<Integer>hs=new HashSet<>();
        int val=1;
        for(int i=0;i<n;i++){
            if(hs.contains(arr[i])){
                continue;
            }
            if(arr[i]>0 && arr[i]==val){
                val++;
                hs.add(arr[i]);
            }
            else if(arr[i]>0 && arr[i]!=val){
                return val;
            }
        }
        return val;
    }
}
