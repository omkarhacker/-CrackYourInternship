class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        // code here 
        
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        ArrayList<Integer> arrset[]=new ArrayList[10];
        for(int i=0;i<10;i++){
            arrset[i]=new ArrayList<>();
        }
        int div=1;
        while(max>=div){
            for(int i=0;i<n;i++){
                int val=(arr[i]/div)%10;
                arrset[val].add(arr[i]);
            }
            int count=0;
            for(int i=0;i<10;i++){
                ArrayList<Integer>adj=arrset[i];
                while(adj.size()>0){
                    arr[count]=adj.get(0);
                    adj.remove(0);
                    count++;
                }
            }
            div=div*10;
        }
    } 
}
