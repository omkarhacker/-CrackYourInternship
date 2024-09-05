import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ratio[] = new double[n];
        for (int i = 0; i < n; i++) {
            ratio[i] = (wage[i] * 1.0) / quality[i];
        }
        double arr[][]=new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=ratio[i];
            arr[i][1]=quality[i];
        }
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        double max=Double.MIN_VALUE;
        double sum=0;
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        for(int i=0;i<k-1;i++){
            sum=sum+arr[i][1];
            pq.add(arr[i][1]);
        }
        double min=Double.MAX_VALUE;
        for(int i=k-1;i<n;i++){
            sum=sum+arr[i][1];
            pq.add(arr[i][1]);
            double val=sum*arr[i][0];
            min=Math.min(min,val);
            sum=sum-pq.remove();
        }
        return min;
    }
}
