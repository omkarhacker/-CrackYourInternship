class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost=0;
        int totalGain=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            totalCost=totalCost+gas[i];
            totalGain=totalGain+cost[i];
        }
        if(totalCost<totalGain){
            return -1;
        }
        int total=0;
        int ans=0;
        for(int i=0;i<n;i++){
            total=total+gas[i]-cost[i];
            if(total<0){
                total=0;
                ans=i+1;
            }
        }
        return ans;
    }
}