import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int indegree[]=new int[n];
        List<Integer>li=new ArrayList<>();
        Queue<Integer>qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            indegree[i]=graph[i].length;
            if(indegree[i]==0){
                qu.add(i);
                li.add(i);
            }
        }
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        while(!qu.isEmpty()){
            int val=qu.remove();
            for(int i=0;i<adj.get(val).size();i++){
                int val1=adj.get(val).get(i);
                indegree[val1]=indegree[val1]-1;
                if(indegree[val1]==0){
                    qu.add(val1);
                    li.add(val1);
                }
            }
        }
        Collections.sort(li);
        return li;
    }
}
