class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n=stations.length;
        if(target<=startFuel){
            return 0;
        }
        if(stations.length==0){
            return -1;
        }
        if(startFuel<stations[0][0]){
            return -1;
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((x,y)->y-x);
        int count=0;
        int i=0;
        while(startFuel<target){
            while(i<n && stations[i][0]<=startFuel){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.isEmpty()){
                return -1;
            }
            startFuel=startFuel+pq.remove();
            count++;
        }
        return count;
    }
}