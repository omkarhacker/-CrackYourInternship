class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        int dist[]=new int[n-1];
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int sum=0;
        for(int i=0;i<n-1;i++){
            dist[i]=heights[i+1]-heights[i];
            if(dist[i]<=0){
                continue;
            }
            pq.add(dist[i]);
            if(pq.size()>ladders){
                int val=pq.remove();
                sum=sum+val;
                if(sum>bricks){
                    return i;
                }
            }
        }
        return n-1;
    }
}