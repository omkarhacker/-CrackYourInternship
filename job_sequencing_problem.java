class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        PriorityQueue<Job>pq=new PriorityQueue<>((x,y)->(y.profit-x.profit));
        int max=-1;
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            max=Math.max(max,arr[i].deadline);
        }
        boolean visited[]=new boolean[max+1];
        int total=0;
        int i=0;
        while(!pq.isEmpty()){
             Job job=pq.remove();
             for(int j=job.deadline;j>0;j--){
                if(!visited[j]){
                    visited[j]=true;
                    total=total+job.profit;
                    i++;
                    break;
                }
             }
        }
        int[] array = new int[] {i, total};
        return array;
    }
}