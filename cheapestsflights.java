import java.util.*;

class Solution {
    class Node{
        int val;
        int cost;
        int stops;
        Node(int val,int cost,int stops){
            this.val=val;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            int val1=flights[i][0];
            int val2=flights[i][1];
            int val3=flights[i][2];
            adj.get(val1).add(new Node(val2,val3,0));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(src,0,0));
        dist[src]=0;
        while(!qu.isEmpty()){
                Node node=qu.remove();
                int val=node.val;
                int cost=node.cost;
                int steps=node.stops;
                if(steps>k){
                    continue;
                }
                for(int j=0;j<adj.get(val).size();j++){
                    Node node1=adj.get(val).get(j);
                    int val1=node1.val;
                    int cost1=node1.cost;
                    if(dist[val1]>cost1+cost){
                        dist[val1]=cost1+cost;
                        qu.add(new Node(val1,dist[val1],steps+1));
                    }
                }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}