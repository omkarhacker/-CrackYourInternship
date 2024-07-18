class Solution {
    class Node{
        int first;
        int second;
        Node(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Node>pq=new PriorityQueue<>((x,y)->(y.first-x.first));
        int n=points.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && points[i][0]-pq.peek().second>k){
                pq.remove();
            }
            if(!pq.isEmpty()){
             ans=Math.max(ans,points[i][0]+points[i][1]+pq.peek().first);
            }
            pq.add(new Node(points[i][1]-points[i][0],points[i][0]));
        }
        return ans;
    }
}