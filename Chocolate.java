//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        
        Collections.sort(a);
        long diff=Integer.MAX_VALUE;
        for(int i=0;i<=n-m;i++){
            int val=i+m-1;
            diff=Math.min(diff,a.get(val)-a.get(i));
        }
        return diff;
    }
}