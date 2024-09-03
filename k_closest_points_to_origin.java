class Solution {
    class Node{
        int i;
        int j;
        int dist;
        Node(int i,int j,int dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node>pq=new PriorityQueue<>((x,y)->y.dist-x.dist);
        for(int i=0;i<points.length;i++){
            int val=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
            pq.add(new Node(points[i][0],points[i][1],val));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int arr[][]=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Node node=pq.remove();
            arr[i][0]=node.i;
            arr[i][1]=node.j;
            i++;
        }
        return arr;
    }
}