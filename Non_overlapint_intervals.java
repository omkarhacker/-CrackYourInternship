class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        int last=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<intervals.length;i++){
            int val1=intervals[i][0];
            int val2=intervals[i][1];
            if(val1>=last){
                last=val2;
            }
            else{
                last=Math.min(last,val2);
                count++;
            }
        }
        return count;
    }
}